package mergeSortTest;

import java.util.Comparator;
import java.util.Iterator;

import dnarvaez27.list.linkedlist.doublell.DoubleLinkedList;
import dnarvaez27.sorts.MergeSort;
import junit.framework.TestCase;

public class TestMergeSort extends TestCase
{
	private DoubleLinkedList<String> doubleLinkedList;

	private void setup1( )
	{
		doubleLinkedList = new DoubleLinkedList<>( "D", "A", "V", "I", "D" );
	}

	public void testSort( )
	{
		setup1( );

		DoubleLinkedList<String> sorted = ( DoubleLinkedList<String> ) MergeSort.sort( doubleLinkedList );
		Iterator<String> it = sorted.iterator( );
		while( it.hasNext( ) )
		{
			String n1 = it.next( );
			if( it.hasNext( ) )
			{
				String n2 = it.next( );

				if( n1.compareTo( n2 ) > 0 )
				{
					fail( );
				}
			}
		}
	}

	public void testSortComparator( )
	{
		setup1( );

		DoubleLinkedList<String> sorted = ( DoubleLinkedList<String> ) MergeSort.sort( doubleLinkedList, new Comparator<String>( )
		{
			@Override
			public int compare( String o1, String o2 )
			{
				return o2.compareTo( o1 );
			}
		} );
		Iterator<String> it = sorted.iterator( );
		while( it.hasNext( ) )
		{
			String n1 = it.next( );
			if( it.hasNext( ) )
			{
				String n2 = it.next( );

				if( n1.compareTo( n2 ) < 0 )
				{
					fail( );
				}
			}
		}

	}
}
