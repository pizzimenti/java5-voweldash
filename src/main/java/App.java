import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      String textInput = request.queryParams("textInput");

      //call business logic functions here
      String result = VowelsToDashes(textInput);


      HashMap model = new HashMap();
      model.put("template", "templates/output.vtl");
      model.put("result", String.format(result));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      //additional pages would go here
  }


  public static String VowelsToDashes (String textInput) {
    char[] vowels = {'a','A','e','E','i','I','o','O','u','U'};

    for(char vowel: vowels) {
      textInput = textInput.replace(vowel,'-');
    }

    return textInput;
  } //end of VowelsToDashes

  public static String Hint (String result, String textInput) {

  //this method causes: not a statement and illegal start of expression
    String textInput = "snuggle"; //defined just for repl testing
    String result = "sn-ggl-"; //defined just for repl testing
    for(int i = 0; i < textInput.length(); i++) {
      if (result.charAt(i) == '-') {
        result.charAt(i) == textInput.charAt(i);
      }
    }

  //this method causes: java.lang.ArrayIndexOutOfBoundsException: 115
    String textInput = "snuggle"; //defined just for repl testing
    String result = "sn-ggl-"; //defined just for repl testing
    char[] resultCharred = result.toCharArray();
    for(char letter: resultCharred) {
      result = result.replace('-',textInput.charAt(letter));
    }


  //this method runs without errors but only places the first character of textInput into the dashed result where there are dashes, not the corresponding character
  String textInput = "snuggle"; //defined just for repl testing
  String result = "sn-ggl-"; //defined just for repl testing
  char[] resultCharred = result.toCharArray();
  for(char letter: resultCharred) {
    result = result.replace('-',letter);
  }


  } //end of Hint
} //end of App class
