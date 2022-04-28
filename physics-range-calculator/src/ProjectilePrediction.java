public class ProjectilePrediction {
    public static void main(String args[])
    {
        double xRange = 80;
        double angle = 45;
        double initialVelocity = ((Math.pow(xRange, 2))*4.9);
        //System.out.println(initialVelocity);
         initialVelocity /= Math.pow(Math.cos(Math.toRadians(angle)),2);
         //System.out.println("Divided by" + Math.pow(Math.cos(Math.toRadians(angle)),2));
         //System.out.println(initialVelocity);
         initialVelocity /= (xRange * Math.tan(Math.toRadians(angle))+ 110);
         //System.out.println(initialVelocity);
         initialVelocity = Math.sqrt(initialVelocity);
         System.out.println(initialVelocity);

    }//main
    
}
