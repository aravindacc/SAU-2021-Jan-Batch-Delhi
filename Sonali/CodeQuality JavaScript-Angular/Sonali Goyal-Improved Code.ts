
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.


//SUBMITTED BY- SONALI GOYAL
//IMPROVED Code 

import { GetNotesTabNoteListQuery, Result, , NoteListPlain,NoteListQueryResult,} from 'ion-actions/note/getNotes';
import { useCallback,useEffect, useMemo, useRef, useState} from 'react';
import { useSelector } from 'react-redux';
import { WatcherResult } from 'conduit-view';

import { isReminderSelector } from '@selectors/remSelector';
import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';
import { selectedNoteSelector } from '@selectors/notesSelector';
import { useSubscription } from '@utils/Helper';

export const noteListSize = 500;
const anotherConst = 0.7;
const initialStartIndex = 0;
const debugPagination = false;

//UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp to NoteListSubscribedToHomeParentNoteList
export const NoteListSubscribedToHomeParentNoteList = ( filters,sort,disablePagination,skip: boolean = false) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  const totalNotes = useRef<number>(0);
  const currentPage = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );
  const isCurrentPageEmpty = currentPage.data?.list.length == 0;
  const numPriorItems = currentPage?.data?.numPriorItems ?? 0;
  const prevPageSize = numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad = currentPage.data != null && currentPage.data?.numPriorItems > 0 && !disablePagination;
  const randomFunction = useMemo(() => {
    let innerlist = currentPage.data
      .concat(
        addDebugInfo(currentPage?.data ?? [], {
          pageName: 'current',
          cached: currentPage === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    currentPage,
    isCurrentPageEmpty,
  ]);

  const result = useMemo(() => { [...currentPage.data] }, [currentPage]);
  return result;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
	
  return (placeholders as unknown) as Result;
}

function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
  if (debugPagination) 
    return list.map(item => ({ ...item, debugInfo }));
  return list;
}
