package jOSeph_4;

import java.awt.*;
import java.util.ArrayList;

public class DualList<E> extends List {
	ArrayList<ArrayList<E>> rows;
	private int noRows = 1024;
	private int noColumns = 1024;


	public DualList(){
		rows = new ArrayList<>();
	}
	/**
	 * Set's row and column restraints
	 * @param rows
	 * @param columns
	 */
	public DualList(int rows, int columns){
		this();
		noColumns = columns;
		noRows = rows;
	}

	/**
	 * Set's size constraints to the list, removing any outside the range
	 * Set both to -1 to remove
	 */
	public void setConstraints(int rows, int columns){
		noColumns = columns;
		noRows = rows;

		if(noRows==-1||noColumns==-1){
			noColumns = 1024;
			noRows = 1024;
			return;
		}

		ArrayList<ArrayList<E>> oldRows = this.rows;
		this.rows = new ArrayList<>();

		for(int i = 0; i<noRows; i++) {
			this.rows.set(i, new ArrayList<>());
			for (int j = 0; j<noColumns; j++) {
				this.rows.get(i).set(j, oldRows.get(i).get(j));
			}
		}
	}

	/**
	 * Set's the specified object to a certain location
	 * @param i Object to set to
	 * @param row Row
	 * @param column Column
	 * @throws IndexOutOfBoundsException If you try to set a value outside the range
	 */
	public void set(E i, int row, int column){
		if(row>=noRows) throw new IndexOutOfBoundsException();
		if(column>=noColumns) throw new IndexOutOfBoundsException();


		while(rows.size()<row+1){
			rows.add(new ArrayList());
		}
		while(rows.get(row).size()<column+1){
			rows.get(row).add(null);
		}
		rows.get(row).set(column, i);
	}
	/**
	 * Get's the specified object from a certain location
	 * @param row Row
	 * @param column Column
	 * @throws IndexOutOfBoundsException If you try to get a value outside the range
	 */
	public E get(int row, int column) throws IndexOutOfBoundsException {
		if(row>=noRows) throw new IndexOutOfBoundsException();
		if(column>=noColumns) throw new IndexOutOfBoundsException();

		return rows.get(row).get(column);
	}
	public void print(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<rows.size();i++){
			for(int j = 0; j<rows.get(i).size();j++){
				if(j!=0) sb.append(", ");
				sb.append(rows.get(i).get(j));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * Returns a list of rows
	 * @return
	 */
	public ArrayList<ArrayList<E>> getListOfRows() {
		return rows;
	}

	/**
	 * Returns a list of columns
	 * @return
	 */
	public ArrayList<ArrayList<E>> getListOfColumns() {
		ArrayList<ArrayList<E>> columns = new ArrayList<>();
		int columnLength = 0;
		for(ArrayList<E> list: rows){
			if(list.size()>columnLength) columnLength = list.size();
		}

		for (int i = 0; i < columnLength; i++){
			ArrayList<E> column = new ArrayList<>();
			for(int j = 0; j<rows.size(); j++){
				column.add(rows.get(j).get(i));
			}
			columns.add(column);
		}

		return columns;
	}


	public ArrayList<E> getRow(int i){
		return rows.get(i);
	}
	public ArrayList<E> getColumn(int i){
		ArrayList<E> column = new ArrayList<>();
		for(ArrayList<E> row: rows){
			column.add(row.get(i));
		}
		return column;
	}

	/**
	 * Get's the number of Rows
	 * @return Limit of rows
	 * @throws NullPointerException If there is no row limit set
	 */
	public int getNumberOfRows(){
		if (noRows==1024) throw new NullPointerException();
		return noRows;
	}
	/**
	 * Get's the number of Columns
	 * @return Limit of columns
	 * @throws NullPointerException If there is no column limit
	 */
	public int getNumberOfColumns(){
		if (noColumns==1024) throw new NullPointerException();
		return noColumns;
	}

	/**
	 * Creates a clone
	 */
	public DualList<E> duplicate(){
		DualList<E> list = new DualList<>();
		list.noColumns = noColumns;
		list.noRows = noRows;

		ArrayList<ArrayList<E>> newRows = new ArrayList<>();

		for(ArrayList<E> row: rows){
			ArrayList<E> newRow = new ArrayList<>();
			for(E element: row){
				newRow.add(element);
			}
			newRows.add(newRow);
		}
		list.rows = newRows;

		return list;
	}
}
