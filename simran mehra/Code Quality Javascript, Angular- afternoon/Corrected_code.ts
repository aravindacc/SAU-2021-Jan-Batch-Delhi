import {  useMemo, useRef, useState } from 'react';
import { useSelector } from 'react-redux'; 
import { GetNotesTabNoteListQuery, Result } from 'ion-actions/note/getNotes';

import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

const anotherConst = 0.7;
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;
export const noteListSize = 500; 

export const useNoteList = (filters, sort, disablePagination, skip: boolean = false) => {
    const x = useSelector(isReminderSelector);
    const [currPage, setCurrPageKey] = useState<null | string>(null);
    const [startIndex, setStartIndex] = useState(initialStartIndex);
    const TOTALNOTES = useRef<number>(0); 
    const CURRENT_PAGE = useSubscription(GetNotesTabNoteListQuery, { noteFilters: filters });
    const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;
    const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
    const prevPageSize = numPriorItems < noteListSize ? numPriorItems : noteListSize;
    const shouldPrevPageLoad = CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;
  
    const randomFunction = useMemo(() => {
        let innerlist = CURRENT_PAGE.data
            .concat(
                addDebugInfo(CURRENT_PAGE?.data ?? [], 
                    {
                        pageName: 'current',
                        cached: CURRENT_PAGE === null,
                    }
                )
            )
        return innerlist;
    }, 
        [
            disablePagination,
            startIndex,
            CURRENT_PAGE,
            isCurrentPageEmpty,
        ]
    );

    const result = useMemo(() => ({...CURRENT_PAGE.data}), [CURRENT_PAGE]);
    return result;
};

function createPlaceholders(count: number, selectedID: string | null): Result {
    const placeholders: Array<Record<string, unknown>> = new Array(count);
    placeholders
        .fill(
            {
                id: selectedID,
                label: undefined,
                updated: undefined,
                debugInfo: { placeholder: true }
            },
            0,
            1
        )
        .fill(
            {
                id: undefined,
                label: undefined,
                updated: undefined,
                debugInfo: { placeholder: true }
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
