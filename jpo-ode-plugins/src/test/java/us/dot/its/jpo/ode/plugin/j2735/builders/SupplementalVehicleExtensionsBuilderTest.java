package us.dot.its.jpo.ode.plugin.j2735.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import mockit.Capturing;
import mockit.Expectations;
import us.dot.its.jpo.ode.plugin.j2735.J2735DisabledVehicle;
import us.dot.its.jpo.ode.plugin.j2735.J2735ObstacleDetection;
import us.dot.its.jpo.ode.plugin.j2735.J2735RTCMPackage;
import us.dot.its.jpo.ode.plugin.j2735.J2735SpeedProfile;
import us.dot.its.jpo.ode.plugin.j2735.J2735SupplementalVehicleExtensions;
import us.dot.its.jpo.ode.plugin.j2735.J2735VehicleClassification;
import us.dot.its.jpo.ode.plugin.j2735.J2735VehicleData;
import us.dot.its.jpo.ode.plugin.j2735.J2735WeatherProbe;
import us.dot.its.jpo.ode.plugin.j2735.J2735WeatherReport;
import us.dot.its.jpo.ode.util.CodecUtils;
import us.dot.its.jpo.ode.util.JsonUtils;

public class SupplementalVehicleExtensionsBuilderTest {

   @Test
   public void testClassification() {

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("classification", 1);

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder
            .genericSupplementalVehicleExtensions(testInput);

      assertEquals(Integer.valueOf(1), result.getClassification());
   }

   @Test
   public void testVehicleClass(@Capturing VehicleClassificationBuilder capturingVehicleClassificationBuilder) {

      new Expectations() {
         {
            VehicleClassificationBuilder.genericVehicleClassification((JsonNode) any);
            result = new J2735VehicleClassification();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("classDetails", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getClassDetails());
   }

   @Test
   public void testVehicleData(@Capturing VehicleDataBuilder capturingVehicleDataBuilder) {

      new Expectations() {
         {
            VehicleDataBuilder.genericVehicleData((JsonNode) any);
            result = new J2735VehicleData();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("vehicleData", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getVehicleData());
   }

   @Test
   public void testWeatherReport(@Capturing WeatherReportBuilder capturingWeatherReportBuilder) {

      new Expectations() {
         {
            WeatherReportBuilder.genericWeatherReport((JsonNode) any);
            result = new J2735WeatherReport();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("weatherReport", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getWeatherReport());
   }

   @Test
   public void testWeatherProbe(@Capturing WeatherProbeBuilder capturingWeatherProbeBuilder) {

      new Expectations() {
         {
            WeatherProbeBuilder.genericWeatherProbe((JsonNode) any);
            result = new J2735WeatherProbe();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("weatherProbe", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getWeatherProbe());
   }

   @Test
   public void testObstacle(@Capturing ObstacleDetectionBuilder capturingObstacleDetectionBuilder) {

      new Expectations() {
         {
            ObstacleDetectionBuilder.genericObstacleDetection((JsonNode) any);
            result = new J2735ObstacleDetection();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("obstacle", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getObstacle());
   }

   @Test
   public void testStatus(@Capturing DisabledVehicleBuilder capturingDisabledVehicleBuilder) {

      new Expectations() {
         {
            DisabledVehicleBuilder.genericDisabledVehicle((JsonNode) any);
            result = new J2735DisabledVehicle();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("status", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getStatus());
   }

   @Test
   public void testSpeedProfile(@Capturing SpeedProfileBuilder capturingSpeedProfileBuilder) {

      new Expectations() {
         {
            SpeedProfileBuilder.genericSpeedProfile((JsonNode) any);
            result = new J2735SpeedProfile();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("speedProfile", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getSpeedProfile());
   }

   @Test
   public void testRtcmPackage(@Capturing RTCMPackageBuilder capturingRTCMPackageBuilder) {

      new Expectations() {
         {
            RTCMPackageBuilder.genericRTCMPackage((JsonNode) any);
            result = new J2735RTCMPackage();
         }
      };

      ObjectNode testInput = JsonUtils.newNode();
      testInput.put("theRTCM", "something");

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getTheRTCM());
   }

   @Test
   public void testEmptyRegional() {

      ObjectNode testInput = JsonUtils.newNode();
      testInput.set("regional", JsonUtils.newNode());

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getRegional());
   }

   @Test
   public void test1Regional(@Capturing CodecUtils capturingCodecUtils) {

      ObjectNode testRegionalNode = JsonUtils.newNode();
      testRegionalNode.put("regionId", 1);
      testRegionalNode.put("regExtValue", "something");

      ObjectNode testInput = JsonUtils.newNode();
      testInput.set("regional", JsonUtils.newArrayNode().add(testRegionalNode));

      J2735SupplementalVehicleExtensions result = SupplementalVehicleExtensionsBuilder.genericSupplementalVehicleExtensions(testInput);

      assertNotNull(result.getRegional());
   }

}
