import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IItem, Item } from 'app/shared/model/item.model';
import { ItemService } from './item.service';

@Component({
  selector: 'jhi-item-update',
  templateUrl: './item-update.component.html'
})
export class ItemUpdateComponent implements OnInit {
  item: IItem;
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    itemno: [],
    name: [],
    amount: [],
    code: []
  });

  constructor(protected itemService: ItemService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ item }) => {
      this.updateForm(item);
      this.item = item;
    });
  }

  updateForm(item: IItem) {
    this.editForm.patchValue({
      id: item.id,
      itemno: item.itemno,
      name: item.name,
      amount: item.amount,
      code: item.code
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const item = this.createFromForm();
    if (item.id !== undefined) {
      this.subscribeToSaveResponse(this.itemService.update(item));
    } else {
      this.subscribeToSaveResponse(this.itemService.create(item));
    }
  }

  private createFromForm(): IItem {
    const entity = {
      ...new Item(),
      id: this.editForm.get(['id']).value,
      itemno: this.editForm.get(['itemno']).value,
      name: this.editForm.get(['name']).value,
      amount: this.editForm.get(['amount']).value,
      code: this.editForm.get(['code']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IItem>>) {
    result.subscribe((res: HttpResponse<IItem>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
