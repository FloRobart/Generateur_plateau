package metier;

public class Score 
{
    private int distance;
    private int nbPoints;

    public Score(int distance, int nbPoints)
    {
        this.distance = distance;
        this.nbPoints = nbPoints;
    }

    public int getDistance() { return this.distance; }
    public int getNbPoints() { return this.nbPoints; }

    public void setDistance(int distance) { this.distance = distance; }
    public void setNbPoints(int nbPoints) { this.nbPoints = nbPoints; }

    public String toString()
    {
        return "Distance : " + this.distance + " - Points : " + this.nbPoints;
    }
    
}
