// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

import { useMemo } from "react";

import { useSubscription } from "src/utils/Helper";
import { GetNotesTabNoteListQuery } from "ion-actions/note/getNotes";

export const noteListSize = 500; // or also can be used in block letter dependig upon convention

export const useNoteListSubscribed = (filters) => {
    
  const CURRENT_PAGE = useSubscription(GetNotesTabNoteListQuery, {
    noteFilters: filters,
  });

  const result = useMemo (
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [CURRENT_PAGE]
  );

  return result;
};