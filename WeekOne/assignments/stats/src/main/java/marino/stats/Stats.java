package marino.stats;

public class Stats {

    /**
     * @author David Marino
     * @version 1.0
     * @date 06-07-2022
     */


    //**********************************
    // Attribute Instances
    //**********************************
    Integer id;
    String stat;
    String player;
    Integer seriesGameNumber;

    //**********************************
    // Getters
    //**********************************
    public Integer getId() {
        return id;
    }

    public String getStat() {
        return stat;
    }

    public String getPlayer() {
        return player;
    }

    public Integer getSeriesGameNumber() {
        return seriesGameNumber;
    }

    //**********************************
    // Setters
    //**********************************

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setSeriesGameNumber(Integer seriesGameNumber) {
        this.seriesGameNumber = seriesGameNumber;
    }

    //**********************************
    // Constructor
    //**********************************
}
