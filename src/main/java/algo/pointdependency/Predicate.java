package algo.pointdependency;


public class Predicate {

  public static String determine(double val){
    if(val == 0){
      return "inline";
    } else if (val > 0 ){
      return "left"; 
    } else {
      return "right";
    }
  }
}
