import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.io.*;
public class Assignment_2019233 
{
	private Scanner sc = new Scanner(System.in); //input taking scanner
	static int count;             // static variable count to maintain the ID number of patients
	
	//class Patient which holds different attributes such as Name,Temperature, Age, Oxygen Level, Institute admitted in and patientsID
	class Patient
	{
		private String Name;               //patients Name
		private int Age; 				   //patients Age
		private float Temperature;         //patients Temperature
		private int OxygenLevel;           //patients Oxygen Level
		private String InstituteAdmitted;  //Institute in which patient is admitted in
		private String PatientID;          //patients ID
		private int RecoveryDays;          //patients Recovery Days
		private boolean admit_status;      //patients admit status
		
		//constructor which sets patient's name, age temperature and oxygen level
		public Patient(String Name,float Temperature, int OxygenLevel, int Age,int ID){
			this.setName(Name);                  //set patients name
			this.setAge(Age);                    //set patients age
			this.setTemperature(Temperature);    //set patients temperature
			this.setOxygenLevel(OxygenLevel);    //set patients oxygen level
			this.setID(ID);                      //set patients ID
			this.setAdmitStatus(false);          //set patients admit status
		}
		
		//setter method to set patients Name
		private void setName(String Name){
			this.Name = Name;
		}
		
		//setter method to set patients age
		private void setAge(int Age){
			this.Age = Age;
		}
		
		//setter method to set patients temperature
		private void setTemperature(float Temperature){
			this.Temperature = Temperature; 
		}
		
		//setter method to set patients oxygen level
		private void setOxygenLevel(int OxygenLevel){
			this.OxygenLevel = OxygenLevel; 
		}
		
		//setter method to set patients institute name
		private void setInstitute(String Institute) {
			this.InstituteAdmitted = Institute;
			System.out.println("Recovery Days for admitted patient ID "+this.getID()+" - ");
			this.setRecoveryDays(sc.nextInt());
		}
		
		// setter method to set ID of a patient
		private void setID(int ID){
			this.PatientID = String.valueOf(ID);
		}
				
		//setter method to set recovery days
		private void setRecoveryDays(int day) {
			this.RecoveryDays = day;
		}
		
		private void setAdmitStatus(boolean status) {
			this.admit_status=status;
		}
		//getter method to get patients Name
		private String getName(){
			return this.Name;
		}
		
		//getter method to get patients Age
		private int getAge(){
			return this.Age;
		}
		
		//getter method to get patients temperature
		private float getTemperature(){
			return this.Temperature;
		}
		
		//getter method to get patients oxygen level
		private int getOxygenLevel(){
			return this.OxygenLevel;
		}
		
		//getter method to get patients institute admitted 
		private String getInstituteAdmitted(){
			return (this.InstituteAdmitted == null ? "" : this.InstituteAdmitted);
		}
		
		//getter method to get patients ID
		private String getID(){
			return this.PatientID;
		}
		
		//getter method to get recovery days
		private int getRecoveryDays() {
			return this.RecoveryDays;
		}
		
		private boolean getAdmitStatus() {
			return this.admit_status;
		}
		
		//getter method to get patients details
		private String getDetails() {
			return "Name: "+this.getName()+"\nTemperature: "+getTemperature()+"\nOxygen Level:"+getOxygenLevel()+"\n"+
			"Admission Status - "+(this.admit_status?"admitted":"not admitted")+"\nInstitute Admitted - "+getInstituteAdmitted()
			+"\nAge :"+this.getAge();
		}
	}
	
	
	//class Health Care Institute containing attributes its Name,Criteria of admission,Beds Available,Admission Status,Patients Data
	// admitted in the Institute and institute patients recovered
	class HealthCareInstitute
	{
		private String Name;                             // Institute Name
		private String Criteria;             		     // Institute's admission criteria 
		private float Temperature_limit;   		 	 	 // Institute's temperature limit
		private int Oxygen_level_limit;       			 // Institute's oxygen level limit
		private int Number_Of_Beds_Available;            // Institute's bed count
		private boolean Admission_Status;                // Institute's admission status
		private HashMap<String,Patient> PatientsData;    // Institute's patients data
		private ArrayList<Patient> Recovered;            // Institute's recovered patients data
		
		
		// constructor for setting the details of the institutes
		public HealthCareInstitute(String Name, String Temperature,String OxygenLevel,String Beds_Available, String Admission_Status){
			this.setName(Name);   //set Name of Institute

			// set Institute admission criteria
			this.setCriteria(Float.parseFloat(Temperature), Integer.parseInt(OxygenLevel));
			
			// Institute bed count
			this.setBedsAvailable(Integer.parseInt(Beds_Available));
			
			// Institute admission status
			this.setAdmissionStatus(Admission_Status);
			
			// Institute patients data
			this.setPatientsData();
		}
		
		
		// setter method to set patients data
		private void setPatientsData(){
			this.PatientsData= new HashMap<String, Patient>();
			this.Recovered= new ArrayList<Patient>();
		}
		
		
		// setter method to set institute name
		private void setName(String Name){
			this.Name=Name;
		}
		
		
		// setter method to set institute temperature and oxygen level limit
		private void setTemperatureAndOxygenLevelLimit(float Temperature, int OxygenLevel){
			this.Temperature_limit= Temperature;
			this.Oxygen_level_limit=OxygenLevel;
		}
		
		
		// setter method to set institute admission criteria
		private void setCriteria(float Temperature, int OxygenLevel){
			this.setTemperatureAndOxygenLevelLimit(Temperature,OxygenLevel);
			this.Criteria = "Temperature should be <= "+getTemperatureLimit()
			+"\nOxygen Level should be >= "+getOxygenLevel();
		}
		
		
		// setter method to set bed count
		private void setBedsAvailable(int Beds_Available){
			this.Number_Of_Beds_Available=Beds_Available;
		}
		
		
		// setter method to set admission status
		private void setAdmissionStatus(String Status){
			this.Admission_Status = (Status.equals("OPEN") ? true : false );	
		}
		
		
		//getter method to get name of institute  
		private String getName(){
			return this.Name;
		}
		
		
		//getter method to get bed count of institute
		private int getBedsAvailable(){
			return this.Number_Of_Beds_Available;
		}
		
		
		//getter method to get temperature limit of institute
		private float getTemperatureLimit(){
			return this.Temperature_limit;
		}
		
		
		//getter method to get oxygen level of institute
		private int getOxygenLevel(){
			return this.Oxygen_level_limit;
		}
		
		
		//getter method to get criteria institute
		private String getCriteria(){
			
			return this.Criteria;
		}
		
		
		//getter method to get admission status  
		private String getAdmissionStatus(){
			
			return (this.getBedsAvailable()-this.PatientsData.size()>0 ? "OPEN" : "CLOSED");
		}
		
		
		//method to admit a patient in the institute
		private void admitPatient(Patient p){
			
			this.PatientsData.put(p.getName(),p);
			p.setInstitute(this.getName());
			p.setAdmitStatus(true);
		}
		
		
		//getter method to get patients in Institute
		private void getPatientsInInstitute(){
			
			for(Entry<String, Patient> p: this.PatientsData.entrySet())
				System.out.println(p.getValue().getName()+" and thier recovery time is "+String.valueOf(p.getValue().getRecoveryDays())+" days");
			if(this.PatientsData.size()==0)
				for(Patient p:this.Recovered)
					System.out.println(p.getName());
		}
		
		
		//getter method to get recovered patients of institute
		private void getRecoveredPatients(){
			
			for(Patient p:this.Recovered)
				System.out.println(p.getName()+" "+p.getID());
		}
		
		
		//method to discharge patients 
		private void dischargePatients(){
			
			for(Entry<String, Patient> p: this.PatientsData.entrySet()){
				System.out.println(p.getValue().getID());
				this.Recovered.add(p.getValue());
				p.getValue().setAdmitStatus(false);
			}
			this.PatientsData.clear();
		}
		
		
		//method to display institute information
		private void displayInstituteInfo(){ 
			
			System.out.println(getName() + "\n" + getCriteria() + "\nNumber of Available Beds - " 
			+ (getBedsAvailable()-this.PatientsData.size()) + "\nAdmission Status: " + getAdmissionStatus());
		}
		
		
		//method that searches a patients details according to its ID
		private String searchPatient(String ID) {
			
			for(Entry<String, Patient> p:PatientsData.entrySet())
				if(p.getValue().getID().equals(ID))
					return p.getValue().getDetails();
			return null;
		}
		
	}
	
	
	//class patientManager that Manages all patients with help of Institute Manager
	// which is an attribute and other attribute is patients that are still in camp and not admitted
	class PatientManager{
		
		
		private InstituteManager InstitutesAvailable;      //Institute Manager
		private ArrayList<Patient> PatientsInCamp;         //patients still in camp and not admitted 
		
		
		//constructor of Patients Manager
		public PatientManager(InstituteManager Hci){
			this.InstitutesAvailable = Hci;                //initialize Institutes available
			this.PatientsInCamp = new ArrayList<Patient>(); // patients in camp
		}
		
		
		//method to allocate an institutes to a patient p and returns its name
		private void allotInstitute(HealthCareInstitute Hci){
			
		    for(Patient p:this.PatientsInCamp){
		    	if(Hci.PatientsData.size()>=Hci.Number_Of_Beds_Available)return;
				if(p.getOxygenLevel()>=Hci.getOxygenLevel() && !p.getAdmitStatus()){
					Hci.admitPatient(p);
				}
		    }
		    for(Patient p:this.PatientsInCamp){
		    	
		    	if(Hci.PatientsData.size()>=Hci.Number_Of_Beds_Available)return;
				if(p.getTemperature()<=Hci.getTemperatureLimit()&&!p.getAdmitStatus()){
					Hci.admitPatient(p);
				}
		    }
		}
		
		
		//method that finds patient details by its ID number
		private void findPatientDetails(String ID){
			
			for(Entry<String, HealthCareInstitute> p:this.InstitutesAvailable.Institutes.entrySet()){
				String pat = p.getValue().searchPatient(ID);
				if(pat!=null) {
					System.out.println(pat);
					return;
				}
			}
			System.out.println("Patient not found in any of the available Health Care Institutes.");
		}
		
		
		//getter method to get patients in camp
		private void getPatientsInCamp(){
			int cnt=0;
			for(Patient p:this.PatientsInCamp)
				if(!p.getAdmitStatus()) cnt++;
			System.out.println(String.valueOf(cnt)+" patients");
		}
		
		
		//method to remove patients from a institute
		private void removePatients() {
			boolean flag=false;
			System.out.println("Account ID removed of admitted patients : ");
			for(int i=0;i<this.PatientsInCamp.size();i++){
				if(this.PatientsInCamp.get(i).getAdmitStatus()){
					flag=true;
					System.out.println(this.PatientsInCamp.get(i).getID());
					this.PatientsInCamp.remove(this.PatientsInCamp.get(i--));
				}
			}
			if(!flag)System.out.println("None");
		}
		
		
		//getter method to get all patients from institute
		private void getAllPatients(){
			for(Patient p:this.PatientsInCamp)
				System.out.println(p.getName()+" "+p.getID());
		}
		
		
		private boolean areAllPatientsAdmitted() {
			for(Patient p:this.PatientsInCamp)
				if(!p.getAdmitStatus())
					return false;
			return true;
		}
	}
	
	
	
	//class institute manager having attributes Institutes List and Map of institutes
	class InstituteManager{
		
		
		private HashMap<String, HealthCareInstitute> Institutes;      // Map of different Institutes with their names
		private ArrayList<HealthCareInstitute> InstituteList;         // list of all Institutes
		
		
		//class constructor that initializes the Map and the List of Institutes
		public InstituteManager(){
			this.Institutes = new HashMap<String, HealthCareInstitute>();	// initialize Map
			this.InstituteList = new ArrayList<HealthCareInstitute>();      // initialize List
		}
		
		
		//method to add an Institute to the Map and the List of all Institutes
		private void addInstitute(HealthCareInstitute Hci) {
			this.Institutes.put(Hci.getName(), Hci);   //add to Map
			this.InstituteList.add(Hci);               //add to List
		}
		
		
		//method to give away Institutes that are closed
		private void getInstitutesClosed(){
			boolean flag =false;
			for(Entry<String, HealthCareInstitute> inst: this.Institutes.entrySet())    // look in the HashMap in which admission status
				if(inst.getValue().Admission_Status){         							// is CLOSED
					flag=true;
					System.out.println(inst.getValue().getName());
				}
			if(!flag)System.out.println("None");
		}
		
		
		//method to give away Institutes that are open
		private void getInstitutesOpen(){
			int cnt=0;
			for(Entry<String, HealthCareInstitute> inst: this.Institutes.entrySet())   // look in the HashMap in which admission status
				if(!inst.getValue().Admission_Status)                                  // is OPEN
					cnt++;
			System.out.println(String.valueOf(cnt)+" institutes are admitting patients currently");
		}
		
		
		//method to give away Institute details
		private void getInstituteDetails(String Name) {                                // display the institute details
			this.Institutes.get(Name).displayInstituteInfo();
		}
		
		
		//method to find all institute patients
		private void getInstitutePatients(String Name) {
			this.Institutes.get(Name).getPatientsInInstitute();                       //display the institute patients still admitted
			this.Institutes.get(Name).getRecoveredPatients();                         // and recovered
		}
	}
	
	
	
	class ApplicationManager{
		
		
		private BufferedReader  sc1= new BufferedReader(new InputStreamReader(System.in));
		private InstituteManager HciManager;
		private PatientManager   PatManager;
		int count;             // static variable count to maintain the ID number of patients
		
		
		public ApplicationManager() {
			this.HciManager= new InstituteManager();
			this.PatManager= new PatientManager(HciManager);
			this.count = 0;                                          //count variable to manage patient ID's
		}
		
		
		//checked
		private void TakePatients() {
			++this.count;
			this.PatManager.PatientsInCamp.add(new Patient(sc.next(),sc.nextFloat(),sc.nextInt(),sc.nextInt(),this.count));
		}
		
																  //checked 
		private void Query1() throws IOException {
			HealthCareInstitute hci = new HealthCareInstitute(sc1.readLine().split(" ")[0],sc1.readLine().split(" ")[3], sc1.readLine().split(" ")[3],sc1.readLine().split(" ")[5] , "OPEN");
			this.HciManager.addInstitute(hci);
			this.HciManager.Institutes.get(hci.getName()).displayInstituteInfo();
			this.PatManager.allotInstitute(hci);
		}
		
		
		private void Query2() {
			this.PatManager.removePatients();                     //checked
		}
		
		
		private void Query3() {
			System.out.println("Accounts removed of Institute whose admission is closed ");
			this.HciManager.getInstitutesClosed();                //checked 
		}
		
		
		private void Query4() {
			this.PatManager.getPatientsInCamp();                  //checked
		}
		
		
		private void Query5() {
			this.HciManager.getInstitutesOpen();                  //checked
		}
		
		
		private void Query6() {
			this.HciManager.getInstituteDetails(sc.next());       // checked
		}
		
		
		private void Query7() {
			this.PatManager.findPatientDetails(sc.next());        // checked
		}
		
		
		private void Query8() {
			this.PatManager.getAllPatients();                     //checked
		}
		
		
		private void Query9() {
			this.HciManager.Institutes.get(sc.next()).getPatientsInInstitute();;     //checked
		}
	}
	
	//class to run application with attributes application manager
	class RunApplication{
		
		private ApplicationManager app;              //application manager
		
		//constructor to run the application
		public RunApplication() {
			this.app = new ApplicationManager();
		}
		
		//method to run()
		private void run() throws IOException {
			
			int numPatients=sc.nextInt();
			
			while(numPatients-->0) {                      //take in patients in the camp
				app.TakePatients();
			}
			
			//look for queries 
			while(!app.PatManager.areAllPatientsAdmitted()) {
				
				int query=sc.nextInt();
				
				if(query==1)
					app.Query1();
				
				else if(query==2)
					app.Query2();
				
				else if(query==3)
					app.Query3();
				
				else if(query==4)
					app.Query4();
				
				else if(query==5)
					app.Query5();
				
				else if(query==6)
					app.Query6();
				
				else if(query==7)
					app.Query7();
				
				else if(query==8)
					app.Query8();
				
				else if(query==9)
					app.Query9();	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Assignment_2019233 obj= new Assignment_2019233();
		Assignment_2019233.RunApplication Myapplication = obj.new RunApplication(); 
		Myapplication.run();
	}

}
