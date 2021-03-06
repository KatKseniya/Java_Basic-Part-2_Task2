package by.epam.task2;
import java.util.ArrayList;
import java.util.Objects;

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

	public int getUserAccountId()
	{
		return userAccountId;
	}

	public void setUserAccountId(int userAccountId)
	{
		this.userAccountId = userAccountId;
	}

	public ArrayList<Note> getNotes()
	{
		return notes;
	}

	public void setNotes(ArrayList<Note> notes)
	{
		this.notes = notes;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NoteBook noteBook = (NoteBook) o;
		return userAccountId == noteBook.userAccountId &&
				notes.equals(noteBook.notes);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(userAccountId, notes);
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
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Note note = (Note) o;
		return id == note.id &&
				title.equals(note.title) &&
				content.equals(note.content) &&
				dateCreated.equals(note.dateCreated);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, title, content, dateCreated);
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
		NoteBookProvider instance = NoteBookProvider.getInstance();
		System.out.println("instance = " + instance);
		NoteBook notebook1 = instance.getNoteBook();

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

	private static NoteBookProvider instance = new NoteBookProvider();
	private  NoteBook noteBook = new NoteBook();
		private NoteBookProvider (){}

	public static NoteBookProvider getInstance(){

		return instance;
	}

	public NoteBook getNoteBook()
	{
		return noteBook;
	}

	public void setNoteBook(NoteBook noteBook)
	{
		this.noteBook = noteBook;
	}
}
