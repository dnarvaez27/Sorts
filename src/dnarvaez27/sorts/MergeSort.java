package dnarvaez27.sorts;

import java.util.Comparator;

import dnarvaez27.list.linkedlist.IList;
import dnarvaez27.list.linkedlist.doublell.DoubleLinkedList;

public class MergeSort
{
	public static <T extends Comparable<T>> IList<T> sort( IList<T> lista )
	{
		return merge_sort( lista, null );
	}

	public static <T extends Comparable<T>> IList<T> sort( IList<T> lista, Comparator<T> comparator )
	{
		return merge_sort( lista, comparator );
	}

	private static <T extends Comparable<T>> IList<T> merge_sort( IList<T> lista, Comparator<T> comparator )
	{
		int ini = 0;
		int end = lista.size( );
		int mid = ( end - ini ) / 2;
		int size = end - mid;
		IList<T> aux1 = new DoubleLinkedList<>( );
		IList<T> aux2 = new DoubleLinkedList<>( );

		aux1.addAll( lista.subList( 0, mid ) );
		aux2.addAll( lista.subList( mid, end ) );
		if( size > 1 )
		{
			aux1 = merge_sort( aux1, comparator );
			aux2 = merge_sort( aux2, comparator );
		}
		lista = merge( aux1, aux2, comparator );
		return lista;
	}

	private static <T extends Comparable<T>> IList<T> merge( IList<T> izquierda, IList<T> derecha, Comparator<T> comparator )
	{
		DoubleLinkedList<T> rta = new DoubleLinkedList<>( );

		int contadorIzq = 0;
		int contadorDer = 0;

		while( !izquierda.isEmpty( ) && !derecha.isEmpty( ) )
		{
			boolean useComparator = comparator != null ? comparator.compare( izquierda.get( contadorIzq ), derecha.get( contadorDer ) ) < 0 : false;
			boolean useClassDefault = izquierda.get( contadorIzq ).compareTo( derecha.get( contadorDer ) ) < 0;
			boolean ordenar = comparator != null ? useComparator : useClassDefault;
			if( ordenar )
			{
				rta.add( izquierda.removeFirst( ) );
			}
			else
			{
				rta.add( derecha.removeFirst( ) );
			}
		}

		if( !izquierda.isEmpty( ) )
		{
			rta.addAll( izquierda );
			izquierda.clear( );
		}
		else if( !derecha.isEmpty( ) )
		{
			rta.addAll( derecha );
			derecha.clear( );
		}
		return rta;
	}
}