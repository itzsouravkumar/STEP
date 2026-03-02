class TravelComputation {

   public static void main(String[] args) {


      // Create a variable name to indicate the person traveling

      String name = "Eric";

      // Create a variable fromCity, viaCity and toCity to indicate the city

      // from city, via city and to city the person is travelling
      String fromCity = "Chennai", viaCity = "Velore", toCity = "Bangalore";

      // Create a variable distanceFromToVia to indicate the distance
	  
      // between the fromCity to viaCity
      double distanceFromToVia = 156.6;

      // Create a variable timeFromToVia to indicate the time taken to

      // travel from fromCity to viaCity in minutes
      int timeFromToVia = 4 * 60 + 4;

      // Create a variable distanceViaToFinalCity to indicate the distance
	  
      // between the viaCity to toCity
      double distanceViaToFinalCity = 211.8;

      // Create a variable timeViaToFinalCity to indicate the time taken to

      // travel from viaCity to toCity in minutes
      int timeViaToFinalCity = 4 * 60 + 25;


      // Create a variable totalDistance to indicate the total distance

      // between the fromCity to toCity
      double totalDistance = distanceFromToVia + distanceViaToFinalCity;

      // Create a variable totalTime to indicate the total time taken to

      // travel from fromCity to toCity in minutes
      int totalTime = timeFromToVia + timeViaToFinalCity;

      // Print the travel details
      System.out.println("The Total Distance travelled by " + name + " from " + 

                         fromCity + " to " + toCity + " via " + viaCity +

                         " is " + totalDistance + " km and " +

                         "the Total Time taken is " + totalTime + " minutes");

   }
}