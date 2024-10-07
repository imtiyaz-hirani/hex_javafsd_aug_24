import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductFileUploadComponent } from './product-file-upload.component';

describe('ProductFileUploadComponent', () => {
  let component: ProductFileUploadComponent;
  let fixture: ComponentFixture<ProductFileUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductFileUploadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductFileUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
