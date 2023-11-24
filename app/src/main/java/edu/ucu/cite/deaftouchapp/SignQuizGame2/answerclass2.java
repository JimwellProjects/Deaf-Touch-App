package edu.ucu.cite.deaftouchapp.SignQuizGame2;

public class answerclass2 {

    private final int optionA;
    private final int optionB;
    private final int optionC;
    private final int optionD;
    private final int questionid;
    private final int answerid;
    private final int imageid;

    public answerclass2(int questionide, int imageide, int optiona, int optionb,int optionc,int optiond, int answeride)
    {
        questionid=questionide;
        imageid=imageide;

        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;

        answerid=answeride;



    }


    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }

    public int getImageid() {
        return imageid;
    }

}
