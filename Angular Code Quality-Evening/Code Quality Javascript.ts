
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.



//Comments is given where there is a violation of the code quality practices as discussed in the session


// In these import statements there should be one empty line between third party imports and application imports.
// Also import should be alphabetized by the module.
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




export const NoteListSize = 500;

// should be in lower camel case and name should be given in such a way that it should convey some meaning
const AnotherCOnst = 0.7;

// should be present at the top of the file along with other import statements
import { useSelector } from 'react-redux';

const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;


// Component name should not be too much large, should be small and desriptive
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters,sort,disablePagination,skip: boolean = false,
) => {

  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);

  // both constants should be in camel case
  const TOTALNOTES = useRef<number>(0);
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;

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

function createPlaceholders(count: number, selectedID?: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,

        // value given should be "null" instead of undefined
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
      // value given should be "null" instead of undefined
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
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
