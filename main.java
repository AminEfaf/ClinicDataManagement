import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.lang.model.util.ElementScanner14;
import javax.print.event.PrintJobListener;

public class main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.print("Please enter the file name: ");

        File clinicFile = new File(scanner.nextLine());
        Scanner clinicFileReader = new Scanner(clinicFile);

        // Categorizing the information
        setLines(clinicFileReader);

        clear_screen();

        String close;

        // Displaying the stored information
        while (true) {
            System.out.print("Which clinic information do wanna see? ");

            String clinic_name = scanner.next();

            clear_screen();

            String path = "/Users/amin/Documents/Project/Test/java/";
            path = path + clinic_name + " ";

            System.out.print("1.Clinic Info"+"\n"+"2.Section Info"+"\n"+"3.Receptionist Info"+"\n"+"4.Doctor Info"+"\n"+"5.Patients Info"+"\n"+"6.History"+"\n"+"\n"+"input: ");

            int sectionNumber = scanner.nextInt();

            switch (sectionNumber) {
                case 1: {
                    clear_screen();

                    File writer = new File(path+"/ClinicInfo.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
                case 2: {
                    clear_screen();

                    File writer = new File(path+"/SectionInfo.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
                case 3: {
                    clear_screen();

                    File writer = new File(path+"/ReceptionistInfo.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
                case 4: {
                    clear_screen();

                    File writer = new File(path+"/DoctorInfo.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
                case 5: {
                    clear_screen();

                    File writer = new File(path+"/PatientsInfo.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
                case 6: {
                    clear_screen();

                    File writer = new File(path+"/History.txt");
                    Scanner myReader = new Scanner(writer);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                    System.out.print("\n"+"Press any key to exit ...");
                    close = scanner.next();
                    clear_screen ();
                }
                break;
            }
        }
    }
    public static void setLines(Scanner scanner) throws IOException {
        String ClinicName = "null", ClinicType = "null", SectionName = "null", SectionType = "null",  RecepName = "null";
        String ManagerName = "null", ManagerSallary = "null", ManagerUsername = "null", ManagerPassword = "null";
        String ReceptionistName = "null", RecepSectionName = "null", RecepSallary = "null", RecepUser = "null";
        String RecepPass = "null", DoctorName = "null",  DoctorType = "null",  DoctorSectionName = "null",  DoctorSallary = "null";
        String DoctorVisitPayment = "null", DoctorPass = "null",  DoctorUser = "null", PatientName = "null",  SicknessType = "null";
        String path = "null", DocName= "null", PatientsWallet = "null",  PatientUser = "null",  PatientPass = "null", PatientsName = "null", DateOfVisit = "null";

        Vector<String> DoctorNames = new Vector<String>();
        Vector<String> PatientNames = new Vector<String>();
    
        Boolean recepInfo = true;
        Boolean docInfo = true;
        boolean patientInfo = true;
        while (scanner.hasNextLine()) {            
            String line = scanner.nextLine();

            // Check if the clinic information has finished or not
            if (line == "") {
                recepInfo = true;
                docInfo = true;
                patientInfo = true;
                continue;
            }

            if (line.charAt(0) == '*') {
                String[] lineData = line.split("-");

                // Extracting variables from the line
                ClinicName = lineData[0].substring(2, lineData[0].length());
                path = "/Users/amin/Documents/Project/Test/java/";

                // Making folder with name of clinic
                path = path + ClinicName;
                File f1 = new File(path);  
                f1.mkdir();  

                // Extracting variables from the line
                ClinicType = lineData[1].substring(1, lineData[1].length());
                if (ClinicType == "")
                ClinicType = "null";
            }

            if (line.charAt(1) == '&') {
                String[] lineData = line.split("-");

                // Extracting variables from the line
                SectionName = lineData[0].substring(2, lineData[0].length());
                if (SectionName == "")
                SectionName = "null";
                SectionType = lineData[1].substring(1, lineData[1].length());
                if (SectionType == "")
                SectionType = "null";
                RecepName = lineData[2].substring(1, lineData[2].length());
                if (RecepName == "")
                RecepName = "null";

                DoctorNames.clear();
                PatientNames.clear();

                // Puting doctor names in vector
                String[] subLineData = line.split("#");
                String[] docLineData = subLineData[0].split("@");
                for (int i=1; i<docLineData.length; i++) {
                    if (docLineData[i].charAt(docLineData[i].length()-1) == '-' || docLineData[i].charAt(docLineData[i].length()-1) == ' ')
                     DoctorNames.add(docLineData[i].substring(0, lineData[i].length()-2));
                    else
                     DoctorNames.add(docLineData[i]);
                }

                // Puting PatientNames names in vector
                String[] supLineData = line.split("@");
                String[] psLineData = supLineData[supLineData.length-1].split("#");
                for (int i=1; i<psLineData.length; i++) {
                    if (psLineData[i].charAt(psLineData[i].length()-1) == '-' || psLineData[i].charAt(psLineData[i].length()-1) == ' ')
                     PatientNames.add(psLineData[i].substring(0, psLineData[i].length()-2));
                    else
                     PatientNames.add(psLineData[i]);
                }

                // Putting information in file
                writeSectionInfo(path, SectionName, SectionType, RecepName, DoctorNames, PatientNames);
            }


            if (line.charAt(1) == 'M') {
                String[] lineData = line.split("-");

                // Extracting variables from the line
                ManagerName = lineData[0].substring(3, lineData[0].length());
                if (ManagerName == "")
                ManagerName = "null";
                ManagerSallary = lineData[1].substring(1, lineData[1].length());
                if (ManagerSallary == "")
                 ManagerSallary = "null";
                else
                 ManagerSallary = lineData[1].substring(1, lineData[1].length()-1)+"$";
                ManagerUsername = lineData[2].substring(1, lineData[2].length());
                if (ManagerUsername == "")
                ManagerUsername = "null";
                ManagerPassword = lineData[3].substring(1, lineData[3].length());
                if (ManagerPassword == "")
                ManagerPassword = "null";

                // Putting information in file
                writeClinicInfo(path, ClinicName, ClinicType, ManagerName, ManagerSallary, ManagerUsername, ManagerPassword);          
            }
            if (line.charAt(1) == 'R') {
                String[] lineData = line.split("-");

                // Extracting variables from the line
                ReceptionistName = lineData[0].substring(3, lineData[0].length());
                if (ReceptionistName == "")
                ReceptionistName = "null";
                RecepSectionName = lineData[1].substring(1, lineData[1].length());
                if (RecepSectionName == "")
                RecepSectionName = "null";
                RecepSallary = lineData[2].substring(1, lineData[2].length());
                if (RecepSallary == "")
                 RecepSallary = "null";
                else
                 RecepSallary = lineData[2].substring(1, lineData[2].length()-1)+"$";
                RecepUser = lineData[3].substring(1, lineData[3].length());
                if (RecepUser == "")
                RecepUser = "null";
                RecepPass = lineData[4].substring(1, lineData[4].length());
                if (RecepPass == "")
                RecepPass = "null";

                // Putting information in file
                writeReceptionistInfo (path, ReceptionistName, RecepSectionName, RecepSallary, RecepUser, RecepPass, recepInfo);
                recepInfo = false;
            }
            if (line.charAt(1) == '@') {
                String[] lineData = line.split("-");

                // Check if it is history or doctor information
                if ((lineData[1].substring(1, lineData[1].length())).charAt(0) == '#') {
                    // Extracting variables from the line
                    DocName = lineData[0].substring(2, lineData[0].length());
                    PatientsName = lineData[1].substring(2, lineData[1].length());
                    DateOfVisit = lineData[2].substring(1, lineData[2].length());

                    // Putting information in file
                    writeHistory (path, DocName, PatientsName, DateOfVisit);
                }
                else {
                    // Extracting variables from the line
                    DoctorName = lineData[0].substring(2, lineData[0].length());
                    if (DoctorName == "")
                     DoctorName = "null";
                    DoctorType = lineData[1].substring(1, lineData[1].length());
                    if (DoctorType == "")
                     DoctorType = "null";
                    DoctorSectionName = lineData[2].substring(1, lineData[2].length());
                    if (DoctorSectionName == "")
                     DoctorSectionName = "null";
                    DoctorSallary = lineData[3].substring(1, lineData[3].length());
                    if (DoctorSallary == "")
                     DoctorSallary = "null";
                    else
                     DoctorSallary = lineData[3].substring(1, lineData[3].length()-1)+"$";
                    DoctorVisitPayment = lineData[4].substring(1, lineData[4].length());
                    if (DoctorVisitPayment == "")
                     DoctorVisitPayment = "null";
                    else
                     DoctorVisitPayment = lineData[4].substring(1, lineData[4].length()-1)+"$";
                    DoctorUser = lineData[5].substring(1, lineData[5].length());
                    if (DoctorUser == "")
                     DoctorUser = "null";
                    DoctorPass = lineData[6].substring(1, lineData[6].length());
                    if (DoctorPass == "")
                     DoctorPass = "null";
        
                    // Putting information in file
                    writeDoctorInfo (path, DoctorName, DoctorType, DoctorSectionName, DoctorSallary, DoctorVisitPayment, DoctorUser, DoctorPass, docInfo);
                    docInfo = false;
                }


                
            }
            if (line.charAt(1) == '#') {
                String[] lineData = line.split("-");

                // Extracting variables from the line
                PatientName = lineData[0].substring(2, lineData[0].length());
                if (PatientName == "")
                PatientName = "null";
                SicknessType = lineData[1].substring(1, lineData[1].length());
                if (SicknessType == "")
                SicknessType = "null";
                PatientsWallet = lineData[2].substring(1, lineData[2].length());
                if (PatientsWallet == "")
                PatientsWallet = "null";
                else
                PatientsWallet = lineData[2].substring(1, lineData[2].length()-1)+"$";
                PatientUser = lineData[3].substring(1, lineData[3].length());
                if (PatientUser == "")
                PatientUser = "null";
                PatientPass = lineData[4].substring(1, lineData[4].length());
                if (PatientPass == "")
                PatientPass = "null";

                // Putting information in file
                writePatientsInfo (path, PatientName, SicknessType, PatientsWallet, PatientUser, PatientPass, patientInfo);
                patientInfo = false;
            } 

        }

    }
    // Putting the variables at center
    public static String format(String line) {
        int len = line.length();
        if (len % 2 == 1) {
            for (int i=0;i<(15-len)/2;i++) {
                line = " " + line;
            }
            for (int i=0;i<(15-len)/2;i++) {
                line = line + " ";
            }

        } else {
            for (int i=0;i<(15-len)/2+1;i++) {
                line = " " + line;
            }
            for (int i=0;i<(15-len)/2;i++) {
                line = line + " ";
            }
        }
        return line;
    }

    // put the Clinic Info in file with given order
    public static void writeClinicInfo (String path, String Clinicname, String Clinictype, String ManagerName, String ManagerSallary, String ManagerUser, String ManagerPass) throws IOException {
        FileWriter writer = new FileWriter(path+"/ClinicInfo.txt", true);
        writer.write("|   ClinicName  |   ClinicType  |  ManagerName  |ManagerSallary |  ManagerUser  |  ManagerPass  |"+"\n");
        writer.write("|" + format(Clinicname) + "|");
        writer.write(format(Clinictype) + "|");
        writer.write(format(ManagerName) + "|");
        writer.write(format(ManagerSallary) + "|");
        writer.write(format(ManagerUser) + "|");
        writer.write(format(ManagerPass) + "|");
        writer.close();
    }

    // put the Section Info in file with given order
    public static void writeSectionInfo (String path, String SectionName, String SectionType, String RecepName, Vector<String> DoctorNames, Vector<String> PatientNames) throws IOException {
        FileWriter writer = new FileWriter(path+"/SectionInfo.txt", true);
        writer.write("SectionName: "+SectionName+"\n");
        writer.write("SectionType: "+SectionType+"\n");
        writer.write("RecepName: "+RecepName+"\n");
        if (DoctorNames.isEmpty())
         writer.write("DoctorNames: "+"null"+"\n");
        else
         writer.write("DoctorNames: "+DoctorNames+"\n");
        if (PatientNames.isEmpty())
         writer.write("PatientNames: "+"null"+"\n");
        else
        writer.write("PatientNames: "+PatientNames+"\n"+"\n"+"  ***  ***  ***"+"\n"+"\n");
      
        writer.close();
    }

    // put the Receptionist Info in file with given order
    public static void writeReceptionistInfo (String path, String ReceptionistName, String RecepSectionName, String RecepSallary, String RecepUser, String RecepPass, boolean recepInfo) throws IOException {
        FileWriter writer = new FileWriter(path+"/ReceptionistInfo.txt", true);
        if (recepInfo)
        writer.write("|   RecepName   |  RecepSection |  RecepSallary |   RecepUser   |   RecepPass   |"+"\n");
        
        writer.write("|" + format(ReceptionistName) + "|");
        writer.write(format(RecepSectionName) + "|");
        writer.write(format(RecepSallary) + "|");
        writer.write(format(RecepUser) + "|");
        writer.write(format(RecepPass) + "|" + "\n");
        writer.close();
    }

    // put the Doctor Info in file with given order
    public static void writeDoctorInfo (String path, String DoctorName, String DoctorType, String DoctorSectionName, String DoctorSallary, String DoctorVisitPayment, String DoctorUser, String DoctorPass, boolean docInfo) throws IOException {
        FileWriter writer = new FileWriter(path+"/DoctorInfo.txt", true);
        if (docInfo)
        writer.write("|   DoctorName  |   DoctorType  | DoctorSection | DoctorSallary |  DoctorVisit  |   DoctorUser  |   DoctorPass  |"+"\n");
        
        writer.write("|" + format(DoctorName) + "|");
        writer.write(format(DoctorType) + "|");
        writer.write(format(DoctorSectionName) + "|");
        writer.write(format(DoctorSallary) + "|");
        writer.write(format(DoctorVisitPayment) + "|");
        writer.write(format(DoctorUser) + "|");
        writer.write(format(DoctorPass) + "|" + "\n");

        writer.close();
    }

    // put the Patients Info in file with given order
    public static void writePatientsInfo (String path, String PatientName, String SicknessType, String PatientsWallet, String PatientUser, String PatientPass, boolean patientInfo) throws IOException {
        FileWriter writer = new FileWriter(path+"/PatientsInfo.txt", true);
        if (patientInfo)
        writer.write("|  PatientName  |  SicknessType | PatientWallet |  PatientUser  |  PatientPass  |"+"\n");
        
        writer.write("|" + format(PatientName) + "|");
        writer.write(format(SicknessType) + "|");
        writer.write(format(PatientsWallet) + "|");
        writer.write(format(PatientUser) + "|");
        writer.write(format(PatientPass) + "|" + "\n");

        writer.close();
    }

    // put the history in file with given order
    public static void writeHistory (String path, String DocName, String PatientsName, String DateOfVisit) throws IOException {
        FileWriter writer = new FileWriter(path+"/History.txt", true);
        writer.write("Dr." + DocName + "visited " + PatientsName + "on " + DateOfVisit + "\n");
        writer.close();
    }

    // Clearing the screen
    public static void clear_screen() {
        System.out.print("\033[H\033[2J");
    }

}