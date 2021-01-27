
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
// Submitted by - Kajal Gupta (kajal.gupta@accolitedigital.com)

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// PROBLEM - 1

// Imports should be grouped in the following order and style:
// 1. standard library imports
// 2. related third party imports
// 3. local application/library specific imports
// 4. blank line between each group of imports.


import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';


//PROBLEM - 2

//Do not import any library which is not used in the file
import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';


//PROBLEM - 3

//This import can be written in a single line only
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';


import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';


//PROBLEM - 4

// const should be declared in block letters only

export const NoteListSize = 500;



//PROBLEM - 5

//A separate grpup of contant declarations and imports should be made.



//PROBLEM - 6

//Name of all the member variables should be descriptive or self-explainatory
const AnotherCOnst = 0.7;
import { useSelector } from 'react-redux';

const initialStartIndex = 0;



//PROBLEM - 7

//Members that have not be used should not be declared

const initialStartKey = null;
const debugPagination = false;


//PROBLEM - 8

//Limit the number of parameters you need in a given method, or use an object to combine the parameters.

export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters,sort,disablePagination,skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);


  const TOTALNOTES = useRef<number>(0);

  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;



  //Problem - 9

// const declaration should be in one line.
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

    // Unnecessary conversion here 
  return (placeholders as unknown) as Result;
}



//Problem - 10

// PageName is not defined
// return value isn't self descriptive. 

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
