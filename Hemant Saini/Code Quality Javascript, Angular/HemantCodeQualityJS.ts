
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

/**********************************************************************/
//              Submitted by :- Hemant Saini                          //
/*********************************************************************/


/** 1. Unnecessary white spaces and imports used */
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



/** 2. Constant name should be in all block letters */
/** For Example : NOTE_LIST_SIZE */
export const NoteListSize = 500;


/** 3. Constants should be managed in a separate file to increase code readability */
const AnotherCOnst = 0.7;

/** 4. Import statements should be clubbed. */
import { useSelector } from 'react-redux';

/** 5. Constants should also be clubbed. (Problem 2 also applies here.) */
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

/** 6. Name of the Component is too large. */
/** It Should be crisp and descriptive*/
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  
  /** 7. Multiple Parameters are not a good practice */
  filters,sort,disablePagination,skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  
  /** 8. An underscore could have been good like TOTAL_NOTES. */
  const TOTALNOTES = useRef<number>(0);

  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  /** 9. Use of round braces here would have increased the readability */
  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;

  /** 10. Everything in one place ; so many functions which are not related in one place */

  /** 11. return statement not used properly. */
  /** Multiple return statements are not a good practice and inside nested function, */
  /** we should not use them */
  const randomFunction = useMemo(() => {
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
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

/** 12. Ternary operator is not properly used. */
function createPlaceholders(count: number, selectedID?: string | null): Result {

  /** 13. We should encapsulate the objects in single object we make array for  */
  /** This improves readability and dependence on other objects also */
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
  /** 14. Unnecessary conversion here */
  return (placeholders as unknown) as Result;
}

/** 15. Unnecessary curly braces could be removed. */
function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}

/** 16. Some things are not defined but used. */
/** 17. Intendation problems at many places as mentioned. */
/** 18. Naming conventions are also not good at many places as mentioned. */