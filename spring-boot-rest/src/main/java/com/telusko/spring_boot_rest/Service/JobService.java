package com.telusko.spring_boot_rest.Service;
import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    public JobService() {

    }
    @Autowired
    private JobRepo repo;

    private JobService service;

    //method to return all JobPosts
//    public List<JobPost> returnAllJobPosts() {
//        return repo.returnAllJobPosts();
//
//
//    }
    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);

    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();

    }

    public JobPost getJob(int postId) {
//        int num = 10/0;

        return repo.findById(postId).orElse(new JobPost());
    }

//    public void addJob(JobPost jobPost) {
//    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>();

        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                3, List.of("iOS Development", "Android Development", "Mobile App")));

        jobs.add(new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

        jobs.add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                2, List.of("User Experience", "User Interface Design", "Prototyping")));

        jobs.add(new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
                4, List.of("Cybersecurity", "Network Security", "Incident Response")));

        jobs.add(new JobPost(9, "Full Stack Developer", "Experience in both front-end and back-end development",
                5, List.of("JavaScript", "Node.js", "React", "Spring", "MongoDB")));

        jobs.add(new JobPost(10, "Cloud Architect", "Design and implement cloud infrastructure solutions", 6,
                List.of("Cloud Computing", "AWS", "Azure", "Google Cloud")));

        jobs.add(new JobPost(11, "Software Tester", "Ensure software quality through testing and validation", 3,
                List.of("Testing", "JUnit", "Selenium", "TestNG")));

        jobs.add(new JobPost(12, "React Native Developer",
                "Develop cross-platform mobile applications using React Native", 2,
                List.of("React Native", "JavaScript", "Mobile App Development")));

        jobs.add(new JobPost(13, "Business Analyst", "Analyze business processes and recommend improvements", 4,
                List.of("Business Analysis", "Requirements Gathering", "Process Modeling")));

        jobs.add(new JobPost(14, "Embedded Systems Engineer",
                "Design and develop embedded systems for hardware applications", 5,
                List.of("Embedded Systems", "C/C++", "Microcontrollers", "RTOS")));

        jobs.add(new JobPost(15, "Content Writer",
                "Create engaging and informative content for websites and publications", 2,
                List.of("Content Writing", "Copywriting", "SEO", "Creative Writing")));

        jobs.add(new JobPost(16, "Business Intelligence Analyst",
                "Utilize data to provide insights and support decision-making", 4,
                List.of("Business Intelligence", "SQL", "Data Warehousing", "Tableau")));

        jobs.add(new JobPost(17, "UX Researcher", "Conduct user research to inform the design process", 3,
                List.of("User Research", "Usability Testing", "Human-Computer Interaction")));

        jobs.add(new JobPost(18, "Backend Developer", "Build server-side logic and databases for web applications",
                        4, List.of("Java", "Spring", "Node.js", "MongoDB")));

        jobs.add(new JobPost(19, "Game Developer", "Create and optimize games for various platforms", 3,
                List.of("Game Development", "Unity", "C#", "3D Modeling")));

        jobs.add(new JobPost(20, "IT Project Manager", "Lead and manage IT projects from initiation to completion",
                6, List.of("Project Management", "Agile", "Scrum", "Risk Management")));

        repo.saveAll(jobs);

    }

    public List<JobPost> search(String keyword) {
       return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);

    }
}
