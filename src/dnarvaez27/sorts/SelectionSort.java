package dnarvaez27.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SelectionSort
{
	public static <T extends Comparable<T>> void sort( List<T> list )
	{
		int tam = list.size( );
		for( int i = 0; i < tam; i++ )
		{
			int menor = i;
			for( int j = i + 1; j < tam; j++ )
			{
				if( list.get( j ).compareTo( list.get( menor ) ) < 0 )
				{
					menor = j;
				}
			}
			T temp = list.get( i );
			list.set( i, list.get( menor ) );
			list.set( menor, temp );
		}
	}

	public static void main( String[ ] args )
	{
		ArrayList<Integer> nums = new ArrayList<>( );
		for( int i = 0; i < 10; i++ )
		{
			Random r = new Random( );
			nums.add( r.nextInt( 10 ) );
		}
		System.out.println( Arrays.toString( nums.toArray( new Integer[ 0 ] ) ) );
		SelectionSort.sort( nums );
		System.out.println( Arrays.toString( nums.toArray( new Integer[ 0 ] ) ) );
	}
}
