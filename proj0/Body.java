import java.lang.Math;
public class Body {
    /* These are instance variables that every "Body" in space have */
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    private static final double G = 6.67e-11; // Gravitational Constant
    private static final String imagesDIR = "./images/";

    /* Body constructor */
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;

    }
    /* Constructor for a copy of a Body */
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    /* returns the displacement vector from the reference point a */
    private double displacement(double a, double b){
        return b - a;
    }

    /* Calculates the distance between two objects Bodies -->  sqrt((x2-x1)^2 - (y2-y1)^2) */
    public double calcDistance(Body b){
        double xDisplacement = displacement(this.xxPos, b.xxPos); // x Displacement vector
        double yDisplacement = displacement(this.yyPos, b.yyPos); // y Displacement vector
        // sqrt((x2-x1)^2 + (y2-y1)^2)
        return Math.sqrt( Math.pow(xDisplacement,2) + Math.pow(yDisplacement,2));
    }

    /* calculates the Gravitational Force exerted between two objects Fg = G*m1*m2/r^2 */
    public double calcForceExertedBy(Body b){
        return (G * (this.mass * b.mass))/ Math.pow(this.calcDistance(b),2);
    }

    /* calculates the force exterted by the x component --> Fx = Fg * dx / r */
    public double calcForceExertedByX(Body b){
        return this.calcForceExertedBy(b) * displacement(this.xxPos, b.xxPos)/ this.calcDistance(b);

    }
    /* calculates the force exterted by the y component --> Fy = Fg * dy / r */
    public double calcForceExertedByY(Body b){
        return this.calcForceExertedBy(b) * displacement(this.yyPos, b.yyPos)/ this.calcDistance(b);

    }
    /* Given an array of bodies, this calculates the net force in the X direction.
     * if the array contains a self body reference, it ignores calculating a self net force. Hence, a body
     * cannot exert a gravity upon itself. */
    public double calcNetForceExertedByX(Body[] bodies){
        double netForce = 0;
        for(Body body : bodies){
            if(!this.equals(body)) {

                netForce += this.calcForceExertedByX(body);
            }
        }
        return netForce;
    }
    /* Given an array of bodies, this calculates the net force in the Y direction.
    * if the array contains a self body reference, it ignores calculating a self net force. Hence, a body
    * cannot exert a gravity upon itself. */
    public double calcNetForceExertedByY(Body[] bodies){
        double netForce = 0;
        for(Body body : bodies){
            if(!this.equals(body)) {

                netForce += this.calcForceExertedByY(body);
            }
        }
        return netForce;
    }

    public void update(double dt, double Fx, double Fy){
        double ax = Fx/this.mass; // Acceleration in the x-axis
        double ay = Fy/this.mass; // Acceleration in the y-axis

        this.xxVel = this.xxVel + ax * dt; // final x-velocity update
        this.yyVel = this.yyVel + ay * dt; // final y-velocity update
        this.xxPos = this.xxPos + this.xxVel * dt; // final x-position update
        this.yyPos = this.yyPos + this.yyVel * dt; // final y-position update

    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,imagesDIR + this.imgFileName);
    }



}
