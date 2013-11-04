package exceptions;


public class WrongDataFormatException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 5194642326730806845L;


    public WrongDataFormatException(String msg){
        super(msg);
    }
}
