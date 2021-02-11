
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

//Thirdparty imports and inbuilt imports should be grouped separetely with a line gap in between
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

//too many empty lines
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

//all imports should come at the top 
import { selectedNoteSelector } from '../../src/selectors/notesSelector';

//all imports should come at the top 
import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



//lower camel case convention for constants
export const NoteListSize = 500;
//lower camel case convention for constants and name of constant is not meaningful
const AnotherCOnst = 0.7;

import { useSelector } from 'react-redux'; //all imports should come at the top 

//constant or identifiers should be declared all together and should be at start just below imports
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = ( //Function name is too long.It should be short and in lower camelcase 
  filters,sort,disablePagination,skip: boolean = false,   //no proper indentation and too many parameters.use an object to combine paramters
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);  // setCurrPageKey - by convention set state method name should be: setCurrPage
  const [startIndex, setStartIndex] = useState(initialStartIndex);   // this is the right way to define set state method
  
//lower camel case convention for constants
  const TOTALNOTES = useRef<number>(0);

//lower camel case convention for constants
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;

  //const Declaration should be in one line and indentation not understandable
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;
  
  //unncessary braces and not idented properly
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

  //not idented properly thus not readable
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
  return (placeholders as unknown) as Result;
}


//bad indentation not understandable
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
