package dnarvaez27.sorts;

import dnarvaez27.list.linkedlist.IList;

public class QuickSort
{
	public static <T extends Comparable<T>> IList<T> sort( IList<T> list )
	{
		quicksort( list, 0, list.size( ) - 1 );
		return list;
	}

	private static <T extends Comparable<T>> void quicksort( IList<T> lista, int inicio, int fin )
	{
		// Trabajo en Clase
		boolean ordenAD = true;// TODO
		T pivote = lista.get( ordenAD ? inicio : fin ); // Se toma el pivote como el inicio o fin dependiendo del orden
		int izq = inicio; // "Puntero" que busca hacia la derecha un número mayor que el pivote
		int der = fin; // "Puntero" que busca hacia la izquierda un número menor que el pivote

		while( izq < der ) // Se ejecuta mientras no se cruzen los "Punteros"
		{
			if( ordenAD )
			{
				// Busca un número mayor que el pivote
				for( ; ( lista.get( izq ).compareTo( pivote ) <= 0 ) && ( izq < der ); izq++ )
				{
					;
				}
				// Busca un número menor que el pivote
				for( ; lista.get( der ).compareTo( pivote ) > 0; der-- )
				{
					;
				}
			}
			else
			{
				// Busca un número menor que el pivote
				for( ; lista.get( izq ).compareTo( pivote ) > 0; izq++ )
				{
					;
				}
				// Busca un número mayor que el pivote
				for( ; ( lista.get( der ).compareTo( pivote ) < 0 ) && ( der > izq ); der-- )
				{
					;
				}
			}

			// Si los "Punteros" no se han cruzado... Swap
			if( izq < der )
			{
				T temp = lista.get( izq );
				lista.set( izq, lista.get( der ) );
				lista.set( der, temp );
			}
		}

		// Cuando se cruzan los "Punteros", he encontrado el lugar del Pivote
		// Se coloca el Pivote en su lugar ( El lugar en el que estaba el número menor/mayor dependiendo el orden )
		// Quedando los menores a su izquierda y los mayores a su derecha, Si se ordena ascendentemente
		// Quedando los mayores a su izquierda y los menores a su derecha, Si se ordena descendentemente
		lista.set( ordenAD ? inicio : fin, lista.get( ordenAD ? der : izq ) );
		lista.set( ordenAD ? der : izq, pivote );

		// Se ordena la lista izquierda ( Primera Mitad )
		if( inicio < ( der - 1 ) )
		{
			quicksort( lista, inicio, der - 1 );
		}
		// Se ordena la lista derecha ( Segunda Mitad )
		if( ( der + 1 ) < fin )
		{
			quicksort( lista, der + 1, fin );
		}
	}

	// public static void main( String[ ] args )
	// {
	// int tam = 50;
	//
	// Random r = new Random( );
	// DoubleLinkedList<Integer> i = new DoubleLinkedList<>( );
	// for( int j = 0; j < tam; j++ )
	// {
	// i.add( r.nextInt( 1000 ) );
	// }
	//
	// long ini = System.nanoTime( );
	// QuickSort.sort( i );
	// long end = System.nanoTime( );
	// long total = end - ini;
	// System.out.println( "TOTAL: " + NumberFormat.getNumberInstance( Locale.US ).format( total ) );
	// System.out.println( i );
	// }
}