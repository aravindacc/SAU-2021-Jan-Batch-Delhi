
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Submitted by- Saachi (saachi.r@accolitedigital.com)

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// PROBLEM -1

//We can have robust and readable imports by defining the paths and baseUrl properties in the compilerOptions section in the tsconfig.json file by creating aliases.
//The major benefit of this comes into play when we need to refactor our components. When we move components around it can create more folders, and therefore create more ../../../ ,
// but if we use aliases, we will not have to update the import statements.

// PROBLEM -2

// Imports should be grouped in the following order and style:
// 1. standard library imports
// 2. related third party imports
// 3. local application/library specific imports
// 4. blank line between each group of imports.


import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';


//PROBLEM -3

//Remove uncessary imports
import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';


//PROBLEM -4

//This import consuming many lines. It should be in one line only.
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';


import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';


//PROBLEM -5

// const should be in block letters

export const NoteListSize = 500;



//PROBLEM -6

//All import statements should be specified together.
//All constants should be specified together
//SOLUTION -If there are too many constants, a good practice will be to make a seperate file defining all constants and import that file whereever needed.


//PROBLEM -7

//constant name is not self descriptive.(Intent for the same is not clear)
const AnotherCOnst = 0.7;
import { useSelector } from 'react-redux';

const initialStartIndex = 0;

//PROBLEM -8


// Remove all code that is not being used
//Unused varaiable specified as null, not required
const initialStartKey = null;
const debugPagination = false;


//PROBLEM -9

//Too long function, refactoring can be one solution
//Limit the number of parameters you need in a given method, or use an object to combine the parameters.

//PROBLEM -10

//Too much indentation problem in below function

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


  ////No proper indentation, function callback should be in a single line
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

//Indentation problem
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


// PageName is not defined
// return value isn't self descriptive. (what kind of list?)
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
