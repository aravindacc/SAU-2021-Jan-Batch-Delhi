
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.


//First Letter should be capitalized
import { IsReminderSelector } from '../../src/selectors/remSelector';
import { UseSubscription } from '../../src/utils/Helper';


import { WatcherResult } from 'conduit-view';

//First Letter should be capitalized
import { UseEffect, UseMemo, UseRef, UseState, UseCallback } from 'react';

import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

//First Letter should be capitalized
import { SelectedNoteSelector } from '../../src/selectors/notesSelector';

import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



//Constant variable should be capitalized
export const NOTE_LIST_SIZE = 500;
const ANOTHER_CONST = 0.7;

//First Letter should be capitalized
import { UseSelector } from 'react-redux';

//Constant variable should be capitalized
const INITIAL_START_INDEX = 0;

//It should be undefined
const INITIAL_START_KEY = undefined;

//Constant variable should be capitalized
const DEBUG_PAGINATION = false;

//Constant variable should be capitalized
export const USE_NOTE_LIST_SUBSCRIBED_TO_PARENT_NOTE_LIST_IN_THE_HOME_VIEW_OF_THE_WEBAPP = (
  filters,sort,disablePagination,skip: boolean = false,) => {
  const X = UseSelector(IsReminderSelector);
  const [CURR_PAGE, SET_CURR_PAGE_KEY] = UseState<null | string>(null);
  const [START_INDEX, SET_START_INDEX] = UseState(INITIAL_START_INDEX);
  const TOTAL_NOTES = UseRef<number>(0);
//Constant variable should be capitalized
  const CURRENT_PAGE = UseSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );
  
//Constant variable should be capitalized
  const IS_CURRENT_PAGE_EMPTY = CURRENT_PAGE.data?.list.length == 0;

  const NUM_PRIOR_ITEMS = CURRENT_PAGE?.data?.NUM_PRIOR_ITEMS ?? 0;
  
  const PREV_PAGE_SIZE =
    NUM_PRIOR_ITEMS < NOTE_LIST_SIZE ? NUM_PRIOR_ITEMS : NOTE_LIST_SIZE;
	
  const SHOULD_PREV_PAGE_LOAD =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.NUM_PRIOR_ITEMS > 0 && !disablePagination;

//Constant variable should be capitalized
  const RANDOM_FUNCTION = UseMemo(() => {
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
    START_INDEX,
    CURRENT_PAGE,
    IS_CURRENT_PAGE_EMPTY,
  ]);
 
//Constant variable should be capitalized
  const RESULT = UseMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return RESULT;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {

//Constant variable should be capitalized
  const PLACE_HOLDERS: Array<Record<string, unknown>> = new Array(count);
  PLACE_HOLDERS
    .fill(
      {
        id: selectedID,
        //It should be null
        label: null,
        updated: null,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        //It should be null
        id: null,
        label: null,
        updated: null,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
	
//Constant variable should be capitalized
  return (PLACE_HOLDERS as unknown) as Result;
}

function addDebugInfo(
  list: RESULT,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): RESULT {
//Constant variable should be capitalized
  if (DEBUG_PAGINATION) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
