package springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springframework.vo.mongo.UserVo;

import com.mongodb.DBCollection;

@Controller
public class MongoController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping("/mongo")
	public ModelAndView list(){
		
		ModelAndView mv = new ModelAndView();
		
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:dbManager.xml"); 
//				ContextLoader.getCurrentWebApplicationContext();
		
		MongoOperations mongoOperation = mongoTemplate;
		 
//		mongoOperation.remove(new Query(Criteria.where("").all()),"mongoTest");
		//비우고 다시..
		mongoOperation.dropCollection("mongoTest");
		
        //save
		for(int i=0;i<20;i++) {
			UserVo user = new UserVo("1"+i, "a"+i, "b c"+i, i*i);
			mongoOperation.save(user, "mongoTest");
		}
 
        //find
        UserVo savedUser = mongoOperation.findOne(
        		new Query(Criteria.where("id").is("10"))
				, UserVo.class
				, "mongoTest");
 
        System.out.println("The data that id is 10 : " + savedUser);
 
        //update
        mongoOperation.updateFirst(
        		new Query(Criteria.where("firstname").is("a17"))
        		, Update.update("lastname", "new lastname")
        		, "mongoTest");
 
        //find
        UserVo updatedUser = mongoOperation.findOne(
        		new Query(Criteria.where("id").is("10"))
				, UserVo.class
				, "mongoTest");
 
        System.out.println("The update data that firstname is a17 : " + updatedUser);
 
        //delete
        mongoOperation.remove(
        		new Query(Criteria.where("id").is("118"))
        		, UserVo.class);
 
        //List
        DBCollection listUser = mongoOperation.getCollection("mongoTest");
        System.out.println("Number of user = " + listUser.count());

        mv.setViewName("mongoTest");
		return mv;
	}
	
}
