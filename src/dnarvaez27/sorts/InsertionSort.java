package dnarvaez27.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InsertionSort<T extends Comparable<? super T>>
{
	public static <T extends Comparable<T>> void sort( List<T> list )
	{
		for( int i = 0; i < list.size( ); i++ )
		{
			for( int j = 0; j < list.size( ); j++ )
			{
				if( list.get( j ).compareTo( list.get( i ) ) > 0 )
				{
					T temp = list.get( i );
					list.set( i, list.get( j ) );
					list.set( j, temp );
				}
			}
		}
	}

	public static void main( String[ ] args )
	{
		ArrayList<Integer> nums = new ArrayList<>( );
		for( int i = 0; i < 10; i++ )
		{
			Random r = new Random( );
			nums.add( r.nextInt( 50 ) );
		}
		System.out.println( Arrays.toString( nums.toArray( new Integer[ 0 ] ) ) );
		InsertionSort.sort( nums );
		System.out.println( Arrays.toString( nums.toArray( new Integer[ 0 ] ) ) );
	}
}