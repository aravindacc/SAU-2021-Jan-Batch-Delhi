
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

//SUBMITTED BY- SONALI GOYAL

//PROBLEM
/*we should create alias in tscongif.json and refactor import statements
  Application imports and third party imports should be grouped separately with empty line.
  Should be Alphabetized by Module name.
  
*/
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

//PROBLEM-too many whitespaces
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



//PROBLEM-lowercamelcase convention is not followed here too.
export const NoteListSize = 500;
//PROBLEM-lowercamelcase convention is not followed here too. Name of Constant is not depicting its true use.
const AnotherCOnst = 0.7;
//PROBLEM-import statement should be at top of file with all other import statements.
import { useSelector } from 'react-redux';

const initialStartIndex = 0;
//PROBLEM-unused constant should be removed
const initialStartKey = null;
const debugPagination = false;

//PROBLEM
/* 
	Function name is too long.It should be short and crispy.
	Function is taking too many Parameters.
	Number Of Parameters should be limited or use an object to combine the parameters.
	Indentation Problem.

*/
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters,sort,disablePagination,skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  //PROBLEM-lowercamelcase convention is not followed here
  const TOTALNOTES = useRef<number>(0);
 //PROBLEM-lower camelcase convention is not followed here.
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
  
  //PROBLEM- const Declaration should be in one line.
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

	//PROBLEM- should be indented properly.Unnecessary braces should be removed.
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
	//PROBLEM- Unnecessary Conversion Here
  return (placeholders as unknown) as Result;
}

//Indentation PROBLEM
//Curly Braces can be removed if single statement is inside 'if'.
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
