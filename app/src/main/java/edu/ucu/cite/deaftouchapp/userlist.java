package edu.ucu.cite.deaftouchapp;

public class userlist {
    private String Id;
    private String Username;
    private String Score;







    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public  userlist(String Id, String Username, String Score) {
        this.Id = Id;
        this.Username = Username;
        this.Score = Score;


    }

}