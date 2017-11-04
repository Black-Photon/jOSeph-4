package jOSeph_4;

import java.awt.*;
import java.util.ArrayList;

public class DualList<E> extends List {
	ArrayList<ArrayList<E>> rows;
	public DualList(){
		rows = new ArrayList<>();
	}

	public void set(E i, int row, int column){
		while(rows.size()<row+1){
			rows.add(new ArrayList());
		}
		while(rows.get(row).size()<column+1){
			rows.get(row).add(null);
		}
		rows.get(row).set(column, i);
	}

	public E get(int row, int column) throws IndexOutOfBoundsException {
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
}
