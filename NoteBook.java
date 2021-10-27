package by.epam.task2;
import java.util.ArrayList;


public class NoteBook
{
	private int userAccountId;
	private ArrayList <Note> notes;

	public NoteBook()
	{
	}

	public NoteBook(int userAccountId, ArrayList<Note> notes)
	{
		this.userAccountId = userAccountId;
		this.notes = notes;
	}



	@Override
	public String toString()
	{
		return "NoteBook1{" +
				"userAccountId='" + userAccountId + '\'' +
				", notes=" + notes +
				'}' ;
	}
}

class Note
{
	private int id;

	private String title;

	private String content;

	private String dateCreated;


	public Note(int id, String title, String content, String dateCreated)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString()
	{
		return "Note{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", dateCreated=" + dateCreated +
				'}' + System.lineSeparator();
	}
}

class NoteBookConsoleView
{
	static void print (NoteBook notes)
	{
		System.out.println(notes);
	}

	static void print (ArrayList <Note> note)
	{
		System.out.println(note);
	}

	static void print (ArrayList <Note> note, int index)
	{
		System.out.println(note.get(index));
	}
}

class Test
{
	public static void main(String[] args)
	{

		ArrayList <Note> db = new ArrayList<Note>();
		NoteBook notebook1 = new NoteBook(1, db);

		db.add(new Note(1, "Text", "Desc", "10/26/2021"));
		db.add(new Note(2, "Text", "Desc", "10/26/2021" ));
		db.add(new Note(3, "Text", "Desc", "10/26/2021" ));

		NoteBookConsoleView.print(notebook1);

		NoteBookConsoleView.print(db);

		NoteBookConsoleView.print(db, 2);

	}
}


class NoteBookProvider
{

	private static NoteBookProvider instance = null;
	private NoteBook noteBook = new NoteBook();
	private NoteBookProvider (){}

	public static NoteBookProvider getInstance(){

		return instance;
	}
}


