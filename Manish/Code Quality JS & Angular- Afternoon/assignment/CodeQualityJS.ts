
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

// There are few piece of code that depend upon other piece of code that is unreachable, so after removing unreachale code, that can be removed too, for example, useState import but initially it is reachable
// in corrected file removing all unreachable or unused code

// rather than using ../../src we can defince it in path and can replace it with only src
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';   // this import is never used in code, can be removed
import { useEffect, useMemo, useRef, useState, useCallback } from 'react'; // useEffect is never used in code can be removed

import {
  Result,
  NoteListQueryResult,  // NoteListQueryResult never used in code, can be removed
  GetNotesTabNoteListQuery,
  NoteListPlain,  // NoteListPlain never used in code, can be removed
} from 'ion-actions/note/getNotes';

import { selectedNoteSelector } from '../../src/selectors/notesSelector';  // import nt used in code can be removed


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree'; // import never used in code can be removed




export const NoteListSize = 500;  // variable naming convention is not followed, should be noteListSize, also export should be in end of file at one place for more readablity

const AnotherCOnst = 0.7;  // naming convention for variable is not followed, also never used in code
import { useSelector } from 'react-redux'; // all import should be at top

const initialStartIndex = 0;
const initialStartKey = null;   //  never used in code, can be removed
const debugPagination = false;

export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (  // variable naming convention is not followed also name can be better
  filters,sort,disablePagination,skip: boolean = false, // sort, skip never used in code, can be removed
) => {
  const x = useSelector(isReminderSelector);    // never used in code can be removed
  const [currPage, setCurrPageKey] = useState<null | string>(null); // never used in code can be removed
  const [startIndex, setStartIndex] = useState(initialStartIndex); // setStartIndex  never used in code can be removed
  const TOTALNOTES = useRef<number>(0);  // never used in code can be removed

  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;  // never used in code can be removed
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination; // never used in code can be removed

  const randomFunction = useMemo(() => {  // never used in code can be removed
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,   // mixing of array, function, -> variable defintion can be simplified for more readablity
    startIndex,
    CURRENT_PAGE,
    isCurrentPageEmpty,
  ]);

  const result = useMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return result;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {   // never used in code can be removed
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
  return (placeholders as unknown) as Result; // unknown is verbose
}

function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName; // no PageName varaible in code
    cached: boolean; // rather than semicolan, comma can be used
  }
): Result {
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo })); // can be replaced with turnary operator
  }
  return list;
}
