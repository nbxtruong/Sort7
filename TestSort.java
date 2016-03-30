import sort.AsciiTracer;
import sort.ObservableSortableData;
import sort.QuickSort;
import sort.Sort;
import sort.SortableComparableData;
import sort.SortableData;
import sort.SwapableArray;
import sort.WinTracer;

/*
 * Created on 24 oct. 2004
 *
 */

/**
 * @author baudon
 * 
 */
public class TestSort {

	public static void sortAndPrint(SortableData<?> sd, Sort sort) {
		sort.doSort(sd);
		for (int i = 0; i < sd.size(); ++i) {
			System.out.print(sd.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort qsort = new QuickSort();
		ObservableSortableData<String> osd = new ObservableSortableData<String>(
				new SortableComparableData<String>(new SwapableArray<String>(
						args)));
		osd.addObserver(new AsciiTracer());
		osd.addObserver(new WinTracer(osd));
		sortAndPrint(osd, qsort);
	}
}