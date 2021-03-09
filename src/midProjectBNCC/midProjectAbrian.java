package midProjectBNCC;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class midProjectAbrian {

	static Scanner scn = new Scanner(System.in);
	static Random rand = new Random();
	static ArrayList<String> namaKarArr = new ArrayList();
	static ArrayList<String> kelaminArr = new ArrayList();
	static ArrayList<String> jabatanArr = new ArrayList();
	static ArrayList<Double> gajiArr = new ArrayList();
	static ArrayList<String> idKarArr = new ArrayList();
	static ArrayList<String> jabManagerArr = new ArrayList();
	static ArrayList<String> jabSupervisorArr = new ArrayList();
	static ArrayList<String> jabAdminArr = new ArrayList();
	
	static int choose = 0;
	static String namaKaryawan = "";
	static String kelamin = "";
	static String jabatan = "";
	static String idKaryawan = "";
	static String bruh = "";
	static double gaji = 0d;
	static int inputIndex = 0;
	static int index = 0;
	
	
	static void insertData() {
		do {
			System.out.print("Input nama karyawan[>=3]: ");
			namaKaryawan = scn.nextLine();
		} while (namaKaryawan.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin[Laki-Laki | Perempuan] (Case sensitive): ");
			kelamin = scn.nextLine();
		} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input jabatan[Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scn.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			jabManagerArr.add(jabatan);
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			jabSupervisorArr.add(jabatan);
		}
		else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			jabAdminArr.add(jabatan);
		}
		
		idKaryawan = "" + (char)(rand.nextInt(26) + 'A') + (char)(rand.nextInt(26) + 'A') + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		System.out.println("Berhasil menambahkan karaywan dengan ID: " + idKaryawan);
		
			
		namaKarArr.add(namaKaryawan);
		kelaminArr.add(kelamin);
		jabatanArr.add(jabatan);
		gajiArr.add(gaji);
		idKarArr.add(idKaryawan);
		
		if (jabManagerArr.size() >= 3 && jabatan.equals("Manager")) {
			String output = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Manager")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabSupervisorArr.size() >= 3 && jabatan.equals("Supervisor")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Supervisor")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabAdminArr.size() >= 3 && jabatan.equals("Admin")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Admin")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabManagerArr.size() % 3 == 0) {
			for (int i = 0; i < jabManagerArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 10/100)));
			}
		}
			
		if (jabSupervisorArr.size() % 3 == 0) {
			for (int i = 0; i < jabSupervisorArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 7.5 / 100)));
			}
		}
		
		if (jabAdminArr.size() % 3 == 0) {
			for (int i = 0; i < jabAdminArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 5/100)));
				
			}
		} 
	}
	
	static void viewData() {
		for (int i = 0; i < namaKarArr.size(); i++) {
			for (int j = i+1; j < namaKarArr.size(); j++) {
				if ((namaKarArr.get(i).compareToIgnoreCase(namaKarArr.get(j))) > 0) {
					String tempNama = namaKarArr.get(i);
					namaKarArr.set(i, namaKarArr.get(j));
					namaKarArr.set(j, tempNama);
					
					String tempKelamin = kelaminArr.get(i);
					kelaminArr.set(i, kelaminArr.get(j));
					kelaminArr.set(j, tempKelamin);
					
					String tempID = idKarArr.get(i);
					idKarArr.set(i, idKarArr.get(j));
					idKarArr.set(j, tempID);
					
					double tempGaji = gajiArr.get(i);
					gajiArr.set(i, gajiArr.get(j));
					gajiArr.set(j, tempGaji);
					
					String tempJabatan = jabatanArr.get(i);
					jabatanArr.set(i, jabatanArr.get(j));
					jabatanArr.set(j, tempJabatan);
				}
			}
		}
		if (!(namaKarArr.size() == 0)) {
			for (int i = 0; i < namaKarArr.size(); i++) {
				System.out.println("No: " + (i+1));
				System.out.println("Kode Karyawan: " + idKarArr.get(i));
				System.out.println("Nama Karyawan: " + namaKarArr.get(i));
				System.out.println("Jenis kelamin: " + kelaminArr.get(i));
				System.out.println("Jabatan karyawan: " + jabatanArr.get(i));
				System.out.println("Gaji karyawan: " + gajiArr.get(i));
		}
		
	}
	}
	
	static void updateData() {
		for (int i = 0; i < namaKarArr.size(); i++) {
			for (int j = i+1; j < namaKarArr.size(); j++) {
				if ((namaKarArr.get(i).compareToIgnoreCase(namaKarArr.get(j))) > 0) {
					String tempNama = namaKarArr.get(i);
					namaKarArr.set(i, namaKarArr.get(j));
					namaKarArr.set(j, tempNama);
					
					String tempKelamin = kelaminArr.get(i);
					kelaminArr.set(i, kelaminArr.get(j));
					kelaminArr.set(j, tempKelamin);
					
					String tempID = idKarArr.get(i);
					idKarArr.set(i, idKarArr.get(j));
					idKarArr.set(j, tempID);
					
					double tempGaji = gajiArr.get(i);
					gajiArr.set(i, gajiArr.get(j));
					gajiArr.set(j, tempGaji);
					
					String tempJabatan = jabatanArr.get(i);
					jabatanArr.set(i, jabatanArr.get(j));
					jabatanArr.set(j, tempJabatan);
				}
			}
		}
		if (!(namaKarArr.size() == 0)) {
			for (int i = 0; i < namaKarArr.size(); i++) {
				System.out.println("No: " + (i+1));
				System.out.println("Kode Karyawan: " + idKarArr.get(i));
				System.out.println("Nama Karyawan: " + namaKarArr.get(i));
				System.out.println("Jenis kelamin: " + kelaminArr.get(i));
				System.out.println("Jabatan karyawan: " + jabatanArr.get(i));
				System.out.println("Gaji karyawan: " + gajiArr.get(i));
		}
	}
		do {
			System.out.print("Input index to update [1-" + namaKarArr.size() + "](0 to cancel): ");
			try {
				index = scn.nextInt();
			} catch (Exception e) {
				index = 0;
			}
			scn.nextLine();
			if (index <= 0 || index > namaKarArr.size()) {
				System.out.println("Input must be number!");
			}
		} while (index <= 0 || index > namaKarArr.size() && index != 0);
		
		do {
			System.out.print("Input nama karyawan[>=3]: ");
			namaKaryawan = scn.nextLine();
		} while (namaKaryawan.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin[Laki-Laki | Perempuan] (Case sensitive): ");
			kelamin = scn.nextLine();
		} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
		
		do {
			System.out.print("Input jabatan[Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scn.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			jabManagerArr.add(jabatan);
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			jabSupervisorArr.add(jabatan);
		}
		else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			jabAdminArr.add(jabatan);
		}
		
		idKaryawan = "" + (char)(rand.nextInt(26) + 'A') + (char)(rand.nextInt(26) + 'A') + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		System.out.println("Berhasil menambahkan karaywan dengan ID: " + idKaryawan);
		
		namaKarArr.set((index-1), namaKaryawan);
		kelaminArr.set((index-1), kelamin);
		jabatanArr.set((index-1), jabatan);
		idKarArr.set((index-1), idKaryawan);
		gajiArr.set((index-1), gaji);
		
		if (jabManagerArr.size() >= 3 && jabatan.equals("Manager")) {
			String output = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Manager")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabSupervisorArr.size() >= 3 && jabatan.equals("Supervisor")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Supervisor")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabAdminArr.size() >= 3 && jabatan.equals("Admin")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < idKarArr.size(); i++) {
				if (jabatanArr.get(i).equals("Admin")) {
					output = output + idKarArr.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (jabManagerArr.size() % 3 == 0) {
			for (int i = 0; i < jabManagerArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 10/100)));
			}
		}
			
		if (jabSupervisorArr.size() % 3 == 0) {
			for (int i = 0; i < jabSupervisorArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 7.5 / 100)));
			}
		}
		
		if (jabAdminArr.size() % 3 == 0) {
			for (int i = 0; i < jabAdminArr.size(); i++) {
				gajiArr.set(i, (gajiArr.get(i) + (gaji * 5/100)));
				
			}
		}
		
	}
	
	static void deleteKaryawan () {
		for (int i = 0; i < namaKarArr.size(); i++) {
			for (int j = i+1; j < namaKarArr.size(); j++) {
				if ((namaKarArr.get(i).compareToIgnoreCase(namaKarArr.get(j))) > 0) {
					String tempNama = namaKarArr.get(i);
					namaKarArr.set(i, namaKarArr.get(j));
					namaKarArr.set(j, tempNama);
					
					String tempKelamin = kelaminArr.get(i);
					kelaminArr.set(i, kelaminArr.get(j));
					kelaminArr.set(j, tempKelamin);
					
					String tempID = idKarArr.get(i);
					idKarArr.set(i, idKarArr.get(j));
					idKarArr.set(j, tempID);
					
					double tempGaji = gajiArr.get(i);
					gajiArr.set(i, gajiArr.get(j));
					gajiArr.set(j, tempGaji);
					
					String tempJabatan = jabatanArr.get(i);
					jabatanArr.set(i, jabatanArr.get(j));
					jabatanArr.set(j, tempJabatan);
				}
			}
		}
		if (!(namaKarArr.size() == 0)) {
			for (int i = 0; i < namaKarArr.size(); i++) {
				System.out.println("No: " + (i+1));
				System.out.println("Kode Karyawan: " + idKarArr.get(i));
				System.out.println("Nama Karyawan: " + namaKarArr.get(i));
				System.out.println("Jenis kelamin: " + kelaminArr.get(i));
				System.out.println("Jabatan karyawan: " + jabatanArr.get(i));
				System.out.println("Gaji karyawan: " + gajiArr.get(i));
		}
		
	}
		else {
			System.out.println("No data!");
		}
		
		do {
			System.out.print("Input index to delete [1-" + namaKarArr.size() + "](0 to cancel): ");
			try {
				inputIndex = scn.nextInt();
			} catch (Exception e) {
				inputIndex = 0;
			}
			scn.nextLine();
			if (inputIndex <= 0 || inputIndex > namaKarArr.size()) {
				System.out.println("Input must be number!");
			}
		} while (inputIndex <= 0 || inputIndex > namaKarArr.size() && inputIndex != 0);
		
		if (inputIndex == 0) {
			System.out.println("");
		}
			
		namaKarArr.remove(namaKarArr.get(inputIndex - 1));
		kelaminArr.remove(kelaminArr.get(inputIndex - 1));
		jabatanArr.remove(jabatanArr.get(inputIndex - 1));
		gajiArr.remove(gajiArr.get(inputIndex - 1));
		idKarArr.remove(idKarArr.get(inputIndex - 1));
		
		}
	
	public static void main(String[] args) {
		do {
			System.out.println("Program data karyawan");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.print(">> ");
			try {
				choose = scn.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scn.nextLine();
			
			switch (choose) {
			case 1:
				insertData();
				break;

			case 2:
				viewData();
				break;
			
			case 3:
				updateData();
				break;
				
			case 4:
				deleteKaryawan();
				break;
			}
		} while (choose != 5);

	}

}

