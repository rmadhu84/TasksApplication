import { TestBed } from '@angular/core/testing';

import { TaskclientService } from './taskclient.service';

describe('TaskclientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TaskclientService = TestBed.get(TaskclientService);
    expect(service).toBeTruthy();
  });
});
