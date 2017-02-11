package dnarvaez27.sorts;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;

import dnarvaez27.list.linkedlist.IList;
import dnarvaez27.list.linkedlist.doublell.DoubleLinkedList;

@Deprecated
public class MergeSort2
{
	/**
	 * Complejidad Aprox. (Sin machetear) O(n-1)<br>
	 * Mas lo que se demora en hacer la sublista
	 *
	 * @param list
	 * @return
	 */
	private static <T extends Comparable<? super T>> IList<IList<T>> div( IList<T> list )
	{
		IList<IList<T>> listList = new DoubleLinkedList<>( );// XXX

		int tam = list.size( );

		if( tam > 1 )
		{
			int mid = tam / 2;
			listList.addAll( div( list.subList( 0, mid ) ) );
			listList.addAll( div( list.subList( mid, tam ) ) );
		}
		else
		{
			listList.add( list );
		}
		return listList;
	}

	/**
	 * Complejidad aprox. (Sin machetear) O(n+n/2)<br>
	 * Tiene operaciones de lista con complejidad O(1)
	 *
	 * @param list1
	 * @param list2
	 * @return
	 */
	private static <T extends Comparable<? super T>> IList<T> merge( IList<T> list1, IList<T> list2, Comparator<T> comparator )
	{
		IList<T> lista = new DoubleLinkedList<>( );// XXX

		int tam1 = list1.size( );
		int tam2 = list2.size( );

		while( ( tam1 > 0 ) || ( tam2 > 0 ) )
		{
			if( ( tam1 != 0 ) && ( tam2 != 0 ) )
			{
				T e1 = list1.getFirst( );
				T e2 = list2.getFirst( );

				if( comparator == null ? ( e1.compareTo( e2 ) < 0 ) : ( comparator.compare( e1, e2 ) < 0 ) )
				{
					list1.removeFirst( );
					lista.add( e1 );
				}
				else
				{
					list2.removeFirst( );
					lista.add( e2 );
				}
			}
			else if( ( tam1 > 0 ) && ( tam2 == 0 ) )
			{
				lista.addAll( list1 );
				break;
			}
			else if( ( tam1 == 0 ) && ( tam2 > 0 ) )
			{
				lista.addAll( list2 );
				break;
			}

			tam1 = list1.size( );
			tam2 = list2.size( );
		}

		return lista;
	}

	/**
	 * Opearciones de lista O(1)
	 *
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> IList<T> sort( IList<T> list )
	{
		IList<IList<T>> lDiv = div( list );

		while( lDiv.size( ) > 1 )
		{
			IList<T> l1 = lDiv.get( 0 );
			IList<T> l2 = lDiv.get( 1 );

			lDiv.removeFirst( );
			lDiv.removeFirst( );

			lDiv.addLast( merge( l1, l2, null ) );
		}
		IList<T> rta = lDiv.get( 0 );

		// list.clear( );
		// list.addAll( lDiv.get( 0 ) );

		return rta;
	}

	public static <T extends Comparable<? super T>> IList<T> sort( IList<T> list, Comparator<T> comparator )
	{
		IList<IList<T>> lDiv = div( list );

		while( lDiv.size( ) > 1 )
		{
			IList<T> l1 = lDiv.get( 0 );
			IList<T> l2 = lDiv.get( 1 );

			lDiv.removeFirst( );
			lDiv.removeFirst( );

			lDiv.addLast( merge( l1, l2, comparator ) );
		}
		IList<T> rta = lDiv.get( 0 );

		// list.clear( );
		// list.addAll( lDiv.get( 0 ) );

		return rta;
	}

	public static void main( String[ ] args )
	{
		System.out.println( "Ini" );
		DoubleLinkedList<Integer> test = new DoubleLinkedList<>( );
		Random r = new Random( );
		for( int i = 0; i < 20; i++ )
		{
			test.add( r.nextInt( 5000 ) );
		}
		System.out.println( "Inicia..." );
		// System.out.println( test );
		System.out.println( test );
		long ini = System.nanoTime( );
		test = ( DoubleLinkedList<Integer> ) MergeSort2.sort( test, new Comparator<Integer>( )
		{
			@Override
			public int compare( Integer o1, Integer o2 )
			{
				return o2.compareTo( o1 );
			}
		} );
		long end = System.nanoTime( );
		System.out.println( "TOTAL MERGE: " + NumberFormat.getInstance( Locale.US ).format( end - ini ) );
		System.out.println( test );// Comentar para valores mayores a 1 Millon

		// System.out.println( "Ini" );
		// DoubleLinkedList<Integer> test = new DoubleLinkedList<>( );
		// Random r = new Random( );
		// for( int i = 0; i < 25; i++ )
		// {
		// test.add( r.nextInt( 5000 ) );
		// }
		// System.out.println( "Inicia..." );
		// // System.out.println( test );
		// System.out.println( test );
		// long ini = System.currentTimeMillis( );
		//
		// test = ( DoubleLinkedList<Integer> ) MergeSort.sort( test );
		//
		// System.out.println( "TOTAL MERGE: " + ( System.currentTimeMillis( ) - ini ) );
		// System.out.println( test );// Comentar para valores mayores a 1 Millon
	}
}