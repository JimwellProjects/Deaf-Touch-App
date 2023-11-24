package edu.ucu.cite.deaftouchapp.FlashCardGame;

public class answerclass {

    private final int optionA;
    private final int optionB;
    private final int questionid;
    private final int answerid;

    public answerclass(int questionide, int optiona, int optionb, int answeride)
    {
        questionid=questionide;
        optionA=optiona;
        optionB=optionb;

        answerid=answeride;



    }


    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }
}
