

public class NBody {
    public static double readRadius(String file_name){
        In PlanetData = new In(file_name);
        int numPlanets = PlanetData.readInt();
        double radius = PlanetData.readDouble();
        return radius;
    }

    public static Body[] readBodies(String file_name){
        In PlanetData = new In(file_name);
        int numPlanets = PlanetData.readInt();

        Body[] planets = new Body[numPlanets];

        double radius = PlanetData.readDouble();
        for(int i = 0; i < numPlanets; i++){
            double xpos =PlanetData.readDouble();
            double ypos =PlanetData.readDouble();
            double xVel =PlanetData.readDouble();
            double yVel =PlanetData.readDouble();
            double m = PlanetData.readDouble();
            String name = PlanetData.readString();
            planets[i] = new Body(xpos, ypos, xVel, yVel, m, name);
        }
        return planets;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);

        Body[] planets = readBodies(filename);

        String Background = "./images/starfield.jpg";

        /** Enables double buffering.
         * A animation technique where all drawing takes place on the offscreen canvas.
         * Only when you call show() does your drawing get copied from the
         * offscreen canvas to the onscreen canvas, where it is displayed
         * in the standard drawing window. */
        StdDraw.enableDoubleBuffering();

        /** Sets up the universe*/
        StdDraw.setScale(-radius,radius);

        /** Clears the drawing window. */
        StdDraw.clear();

        /*
        StdDraw.picture(0,0,Background);


        for (Body planet : planets){
            planet.draw();
        }
        // Shows the drawing to the screen, and waits 2000 milliseconds.
        StdDraw.show();
        StdDraw.pause(2000);
        */
        double time = 0;
        while(time <= T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int indx = 0; // planet array index
            for(Body planet: planets){
                xForces[indx] = planet.calcNetForceExertedByX(planets);
                yForces[indx] = planet.calcNetForceExertedByY(planets);
                indx +=1;
            }
            StdDraw.picture(0,0,Background);
            indx = 0; // planet array index
            for (Body planet: planets){
                planet.draw();
                planet.update(dt, xForces[indx],yForces[indx]);
                indx +=1;
            }
            StdDraw.show();
            StdDraw.pause(1);
            StdDraw.clear();
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
