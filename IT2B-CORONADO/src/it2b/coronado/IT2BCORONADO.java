package it2b.coronado;

import java.util.Scanner;

public class IT2BCORONADO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
            System.out.println("======================");
            System.out.println("| WELCOME TO PROJECT |");
            System.out.println("| 1. Add             |");
            System.out.println("| 2. View            | ");
            System.out.println("| 3. Edit            | ");
            System.out.println("| 4. Delete          |");
            System.out.println("======================");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;        
                case 3:
                    view();
                    edit();
                    view();
                    break;        
                case 4:
                    view();
                    delete();
                    view();
                    break;        

            }
            
          System.out.println("Do you want to continue? (Y/N): ");
          response = sc.next();
          
        }while(response.equalsIgnoreCase("y"));
        
    }
    
    public static void add(){
    
        Scanner sc = new Scanner(System.in);
        
        config conf = new config();
        System.out.print("Add Project Title: ");
        String title = sc.nextLine();
        
        System.out.print("Add Rroject Description: ");
        String desc = sc.nextLine();
        
        System.out.print("Add Submission date: ");
        String date = sc.nextLine();
        
        System.out.print("Add Grade: ");
        double grade = sc.nextDouble();

        String sql = "INSERT INTO tbl_projects (project_title, project_description, submission_date, grade) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, title, desc, date, grade);

    }

    public static void delete(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_projects WHERE project_id = ?";
        conf.deleteRecord(sql, id);

    }


    public static void edit(){
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter ID to Edit: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("New Project Title: ");
        String title = sc.nextLine();
        
        System.out.print("New Project Description: ");
        String desc = sc.nextLine();
        
        System.out.print("New Submission date: ");
        String date = sc.nextLine();
        
        System.out.print("New Grade: ");
        double grade = sc.nextDouble();
        
        String qry = "UPDATE tbl_projects SET project_title = ?, project_description = ?, submission_date = ?, grade = ? WHERE project_id= ?";
       
        conf.updateRecord(qry, title, desc, date, grade, id);
        
    }

    public static void view() {
        config conf = new config();
         
        String votersQuery = "SELECT * FROM tbl_projects";
        String[] votersHeaders = {"ID", "Title", "Description", "Submission Date", "Grade"}; // DISPLAY RANI (DI MO MATTER)
        String[] votersColumns = {"project_id", "project_title", "project_description", "submission_date", "grade"}; // SHOULD EXACTLY MATCH UNSAY NAA SA DATABASE

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
}
