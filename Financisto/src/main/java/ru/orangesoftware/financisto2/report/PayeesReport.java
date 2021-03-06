/*******************************************************************************
 * Copyright (c) 2010 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Denis Solonenko - initial API and implementation
 ******************************************************************************/
package ru.orangesoftware.financisto2.report;

import android.content.Context;
import ru.orangesoftware.financisto2.blotter.BlotterFilter;
import ru.orangesoftware.financisto2.db.CategoryRepository;
import ru.orangesoftware.financisto2.filter.WhereFilter;
import ru.orangesoftware.financisto2.filter.Criteria;
import ru.orangesoftware.financisto2.db.DatabaseAdapter;
import ru.orangesoftware.financisto2.model.Currency;

import static ru.orangesoftware.financisto2.db.DatabaseHelper.V_REPORT_PAYEES;

public class PayeesReport extends Report {

	public PayeesReport(Context context, Currency currency) {
		super(ReportType.BY_PAYEE, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_PAYEES, filter);
	}

	@Override
	public Criteria getCriteriaForId(CategoryRepository categoryRepository, long id) {
		return Criteria.eq(BlotterFilter.PAYEE_ID, String.valueOf(id));
	}		
	
}
