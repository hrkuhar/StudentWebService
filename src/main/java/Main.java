import static spark.Spark.*;
import com.google.gson.*;

import java.util.List;

import spark.route.RouteOverview;
import spark.servlet.SparkApplication;
import spark.Response;

public class Main {
	
	static Gson gson = new Gson();
	
	public static void main(String[] args) {
		get("/get", (req, res) -> {
			DBService service = new DBService();
			ActionResult<List<Student>> result = service.getStudents();
            return gson.toJson(result);
		});
		
		post("/insert", (req, res) -> {
			DBService service = new DBService();
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            Student student = gson.fromJson(jsonObject, Student.class);
            ActionResult<Boolean> result = service.insertStudent(student);
            return gson.toJson(result);
		});
		
		post("/update", (req, res) -> {
			DBService service = new DBService();
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            Student student = gson.fromJson(jsonObject, Student.class);
            ActionResult<Boolean> result = service.updateStudent(student);
            return gson.toJson(result);
		});
		
		post("/delete", (req, res) -> {
			DBService service = new DBService();
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            Student student = gson.fromJson(jsonObject, Student.class);
            ActionResult<Boolean> result = service.deleteStudent(student);
            return gson.toJson(result);
		});
	}
}