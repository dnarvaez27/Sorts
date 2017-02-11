package dnarvaez27.sorts;

import java.util.List;

public class BubbleSort<T extends Comparable<? super T>>
{
	public static <T extends Comparable<T>> void sort( List<T> list )
	{
		for( int i = 0; i < list.size( ); i++ )
		{
			for( int j = 0; j < ( list.size( ) - 1 ); j++ )
			{
				T act = list.get( j );
				T nex = list.get( j + 1 );
				int comp = nex.compareTo( act );
				if( comp < 0 )
				{
					T temp = act;
					list.set( j, nex );
					list.set( j + 1, temp );
				}
			}
		}
	}
}