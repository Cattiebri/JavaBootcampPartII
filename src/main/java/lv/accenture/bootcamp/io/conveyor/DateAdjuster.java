package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.db.DBUtil;
import lv.accenture.bootcamp.network.SunAPIService;
import lv.accenture.bootcamp.spring.NotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DateAdjuster {

    @Autowired
    private SunAPIService sunAPIService;


    public void adjustLectionTime() {


        Connection connection = null;

        try {

            Path path = Paths.get("./documents/course-id.txt");
            List<String> data = Files.readAllLines(path);
            String listString = data.get(0);
            Long idToUse = Long.parseLong(listString);
            System.out.println("course ID = " + idToUse);

            connection = DBUtil.acquireConnection();

            PreparedStatement stmt = connection.prepareStatement
                    ("select ID,LECTION_DTM from LECTION WHERE course_id=?");
            stmt.setLong(1, idToUse);
            ResultSet result = stmt.executeQuery();
             SimpleDateFormat simpleDateFormat = null;

            while (result.next()) {
                Long lectionId = result.getLong("ID");
                java.sql.Date lectionDate = result.getDate("LECTION_DTM");
                long lectionDateRaw = lectionDate.getTime();
                // System.out.println("row = " + lectionId + " date msec : " + lectionDateRaw);

                simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
                String lectionDateFormatted = simpleDateFormat.format(new java.util.Date(lectionDateRaw));

                java.util.Date sunriseDate = sunAPIService.getSunrise(lectionDateFormatted);
                System.out.println("Date: " + lectionDateFormatted + " | sunrise : " + sunriseDate);

                long sunriseTimeRaw = sunriseDate.getTime();

                //to insert in prepared statement
                Timestamp timestamp = new Timestamp(sunriseTimeRaw + lectionDateRaw);


                PreparedStatement ptmt = connection.prepareStatement
                        ("UPDATE LECTION SET LECTION_DTM = ? WHERE ID=?");
                ptmt.setTimestamp(1, timestamp);
                ptmt.setLong(2, lectionId);

                int updatedWithPrepared = ptmt.executeUpdate();
            }

            result.close();;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
