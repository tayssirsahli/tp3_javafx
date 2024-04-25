package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	private List<Person> importlist;
	private List<Person> exportlist;
	
	
	public DataClass() {
		importlist = new ArrayList<Person>();
		importlist.add(new Person("sami","BenAli","sami@gmail.com"));
		importlist.add(new Person("Alia","BenSalah","alia@gmail.com"));
		importlist.add(new Person("Ali","BenSalah","ali@gmail.com"));

		
		exportlist = new ArrayList<Person>();
	}


	public List<Person> getImportlist() {
		return importlist;
	}


	public List<Person> getExportlist() {
		return exportlist;
	}


	public void setExportlist(List<Person> exportlist) {
		this.exportlist.addAll(exportlist);
		for(Person p :this.exportlist)
			System.out.println(p);
		
	}

}
