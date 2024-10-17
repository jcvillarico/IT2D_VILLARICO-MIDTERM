package it2d;

import java.util.Scanner;

public class IT2d {
   

    public static void main(String[] args) {
        String response;
        IT2d Library = new IT2d();

        do {
            Scanner sc=new Scanner(System.in);
            System.out.println("Choose an action:");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            
            System.out.print("Enter action number: ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    Library.addLibrary();
                    break;
                case 2:
                    Library.viewLibrary();
                    break;  
                case 3:
                    Library.viewLibrary();
                    Library.updateLibrary();
                    Library.viewLibrary();
                    break;
                case 4:
                    Library.viewLibrary();
                    Library.deleteLibrary();
                    Library.viewLibrary();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.print("Do you want to continue? (yes or no): ");
            response = sc.next();

        } while (response.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you, see you!");
       
    }

    public void addLibrary() {
        Scanner sc = new Scanner(System.in);
       
       
        System.out.print("BOOK TITLE: ");
        String book_title = sc.next();
        System.out.print("AUTHOR: ");
        String author = sc.next();
        System.out.print("ISBN: ");
        String isbn = sc.next();
        System.out.println("AVAILABILITY: ");
        String availability = sc.next();
        System.out.println("PUBLISHED YEAR: ");
        String published_year = sc.next();

        String sql = "INSERT INTO tbl_library ( book_title, author, isbn, availability, published_year) VALUES (?, ?, ?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, book_title, author, isbn, availability, published_year);
    }

    private void viewLibrary() {
        config conf = new config();
        String query = "SELECT * FROM tbl_library";
        String[] headers = { "library_id","book_title", "author", "isbn", "availability"};
        String[] columns = {" library_id","book_title", "author", "isbn", "availability"};

        conf.viewRecords(query, headers, columns);
    }

    private void updateLibrary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();

        System.out.print("BOOK TITLE: ");
        String book_title = sc.next();
        System.out.print("AUTHOR: ");
        String author = sc.next();
        System.out.print("ISBN: ");
        String isbn = sc.next();
        System.out.println("AVAILABILITY: ");
        String availability = sc.next();
        System.out.println("PUBLISHED YEAR: ");
        String year = sc.next();

        
        String qry = "UPDATE tbl_library SET  book_title = ?, author = ?, isbn = ?, availability = ?, published year = ? WHERE e_id = ?";
        config conf = new config();
        conf.updateRecord(qry, book_title, author, isbn, availability, year); 
    }

    private void deleteLibrary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_library WHERE e_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
