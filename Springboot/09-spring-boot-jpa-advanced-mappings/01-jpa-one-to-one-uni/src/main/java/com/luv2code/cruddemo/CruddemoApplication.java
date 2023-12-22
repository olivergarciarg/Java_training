package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorByIdJoinFetch(appDAO);
//			findInstructorByIdJoinFetch2(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteCourse(appDAO);
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding course with id: " + theId);
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println("Found course: " + tempCourse);
		System.out.println("Found reviews: " + tempCourse.getReviews());
		System.out.println("done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving course: " + tempCourse);
		System.out.println("Reviews: " + tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding course with id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("The Pinball Masterclass 2");
		appDAO.update(tempCourse);
		System.out.println("done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		tempInstructor.setFirstName("Chad4");
		tempInstructor.setLastName("Darby4");
		appDAO.update(tempInstructor);
		System.out.println("done!");
	}

	private void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Found courses: " + tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding courses for instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("Found courses 2: " + tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Found courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad3", "Darby3", "darby3@z.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube3", "Luv 3 code!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");

		Course tempCourse2 = new Course("The Pinball Masterclass");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor detail with id: " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Found instructor detail: " + tempInstructorDetail);
		System.out.println("Found instructor: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor with id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad2", "Darby2", "darby2@z.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("done!");
	}
}
