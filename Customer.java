package bookstoreapp;

/**
 *
 * @author vguru
 */
public class Customer {
    private String user, pass, status;
    private int pts;
    
    public Customer(String user, String pass, int pts) {
        this.user = user;
        this.pass = pass;
        this.pts = pts;
        status = (pts > 1000) ? "Gold" : "Silver";
    }

    public String getUser() {
        return user;
    }
    
    public String getPass() {
        return pass;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus() {
        status = (pts > 1000) ? "Gold" : "Silver";
    }
    
    @Override
    public String toString() {
        return user + " " + pass + " " + pts;
    }
}
